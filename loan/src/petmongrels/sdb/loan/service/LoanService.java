package petmongrels.sdb.loan.service;

import petmongrels.sdb.application.request.CreateLoanRequest;
import petmongrels.sdb.product.service.ProductService;

public class LoanService {
    ProductService productService;

    public LoanService(ProductService productService) {
        this.productService = productService;
    }

    public void create(CreateLoanRequest request) {
        productService.validateTerms(request.ProductId, request.loanTerms());
    }
}
