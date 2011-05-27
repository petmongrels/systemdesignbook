package petmongrels.sdb.product.service;

import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.product.domain.LoanProduct;
import petmongrels.sdb.product.repository.AllLoanProducts;
import petmongrels.sdb.validation.ValidationErrors;

public class ProductService {
    AllLoanProducts allLoanProducts;

    public ProductService() {
        this(new AllLoanProducts());
    }

    public ProductService(AllLoanProducts allLoanProducts) {
        this.allLoanProducts = allLoanProducts;
    }

    public ValidationErrors verifyTerms(long productId, LoanTerms loanTerms) {
        LoanProduct loanProduct = allLoanProducts.get(productId);
        return loanProduct.verifyTerms(loanTerms);
    }
}
