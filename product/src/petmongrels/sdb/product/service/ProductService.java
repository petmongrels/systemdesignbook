package petmongrels.sdb.product.service;

import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.product.repository.LoanProductRepository;

public class ProductService {
    private LoanProductRepository loanProductRepository;

    public ProductService(LoanProductRepository loanProductRepository) {
        this.loanProductRepository = loanProductRepository;
    }

    public void validateTerms(long productId, LoanTerms loanTerms) {
        loanProductRepository.load(productId);
    }
}
