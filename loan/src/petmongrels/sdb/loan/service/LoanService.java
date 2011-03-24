package petmongrels.sdb.loan.service;

import petmongrels.sdb.application.request.CreateLoanRequest;
import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.customer.service.CustomerService;
import petmongrels.sdb.product.service.ProductService;

public class LoanService {
    ProductService productService;
    private CustomerService customerService;

    public LoanService(ProductService productService, CustomerService customerService) {
        this.productService = productService;
        this.customerService = customerService;
    }

    public void create(CreateLoanRequest request) {
        LoanTerms loanTerms = request.loanTerms();
        productService.verifyTerms(request.ProductId, loanTerms);
        customerService.verifyNewLoanTerms(request.CustomerId, loanTerms);
    }
}
