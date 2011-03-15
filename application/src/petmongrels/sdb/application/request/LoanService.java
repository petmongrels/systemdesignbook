package petmongrels.sdb.application.request;

import petmongrels.sdb.product.service.ProductService;

public class LoanService {
    ProductService productService;

    public LoanService(ProductService productService) {
        this.productService = productService;
    }

    public void create(CreateLoanRequest request) {
        productService.validateTerms(request.ProductId, );
    }
}
