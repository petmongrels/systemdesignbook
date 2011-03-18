package petmongrels.sdb.product.service;

import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.product.domain.LoanProduct;
import petmongrels.sdb.product.repository.LoanProducts;

import java.util.List;

public class ProductService {
    LoanProducts loanProducts;

    public ProductService(LoanProducts loanProducts) {
        this.loanProducts = loanProducts;
    }

    public List<String> verifyTerms(long productId, LoanTerms loanTerms) {
        LoanProduct loanProduct = loanProducts.get(productId);
        return loanProduct.verifyTerms(loanTerms);
    }
}
