package petmongrels.sdb.loan.service;

import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.application.request.NewLoanResponse;
import petmongrels.sdb.customer.service.CustomerService;
import petmongrels.sdb.loan.domain.Loan;
import petmongrels.sdb.loan.domain.LoanFactory;
import petmongrels.sdb.loan.repository.Loans;
import petmongrels.sdb.loan.responsefactory.NewLoanResponseFactory;
import petmongrels.sdb.product.service.ProductService;
import petmongrels.sdb.validation.ValidationErrors;

public class LoanService {
    ProductService productService;
    CustomerService customerService;
    Loans loans;
    LoanEventsListeners listeners = new LoanEventsListeners();

    public LoanService() {
        this(new ProductService(), new CustomerService(), new Loans());
    }

    public LoanService(ProductService productService, CustomerService customerService, Loans loans) {
        this.productService = productService;
        this.customerService = customerService;
        this.loans = loans;
    }

    public void addListener(LoanEventsListener listener) {
        listeners.add(listener);
    }

    public NewLoanResponse create(NewLoanRequest request) {
        LoanTerms loanTerms = request.loanTerms();
        ValidationErrors errors = productService.verifyTerms(request.ProductId, loanTerms);
        errors.append(customerService.verifyNewLoanTerms(request.CustomerId, loanTerms));
        if (errors.exist()) return NewLoanResponseFactory.create(errors);
        Loan loan = new LoanFactory().newLoan(request);
        loans.add(loan);
        listeners.loanCreated(loan.getId());
        return NewLoanResponseFactory.create(loan);
    }
}