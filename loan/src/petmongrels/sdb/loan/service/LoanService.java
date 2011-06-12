package petmongrels.sdb.loan.service;

import petmongrels.sdb.application.request.DisburseLoanRequest;
import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.application.response.DisburseLoanResponse;
import petmongrels.sdb.application.response.NewLoanResponse;
import petmongrels.sdb.customer.service.CustomerService;
import petmongrels.sdb.loan.domain.LoanAccount;
import petmongrels.sdb.loan.domain.LoanAccountFactory;
import petmongrels.sdb.loan.repository.AllLoans;
import petmongrels.sdb.loan.responsefactory.NewLoanResponseFactory;
import petmongrels.sdb.product.service.ProductService;
import petmongrels.sdb.validation.ValidationErrors;

public class LoanService {
    ProductService productService;
    CustomerService customerService;
    AllLoans allLoans;
    LoanEventsListeners listeners = new LoanEventsListeners();

    public LoanService() {
        this(new ProductService(), new CustomerService(), new AllLoans());
    }

    public LoanService(ProductService productService, CustomerService customerService, AllLoans allLoans) {
        this.productService = productService;
        this.customerService = customerService;
        this.allLoans = allLoans;
    }

    public void addListener(LoanEventsListener listener) {
        listeners.add(listener);
    }

    public NewLoanResponse create(NewLoanRequest request) {
        LoanTerms loanTerms = request.loanTerms();
        ValidationErrors errors = productService.verifyTerms(request.ProductId, loanTerms);
        errors.append(customerService.verifyNewLoanTerms(request.CustomerId, loanTerms));
        if (errors.exist()) return NewLoanResponseFactory.create(errors);
        LoanAccount loanAccount = new LoanAccountFactory().newAccount(request);
        allLoans.add(loanAccount);
        listeners.loanCreated(loanAccount.id());
        return NewLoanResponseFactory.create(loanAccount);
    }
}