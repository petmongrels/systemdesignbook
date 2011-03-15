package petmongrels.sdb.product.repository;

import petmongrels.sdb.product.domain.LoanProduct;

public class LoanProductRepository {
    public LoanProduct load(long productId) {
        return new LoanProduct();
    }
}
