package petmongrels.sdb.product.repository;

import org.hibernate.Session;
import petmongrels.sdb.infrastructure.hibernate.SessionRepository;
import petmongrels.sdb.product.domain.LoanProduct;

public class AllLoanProducts {
    Session session;

    public AllLoanProducts() {
        this(SessionRepository.getCurrentSession());
    }

    public AllLoanProducts(Session session) {
        this.session = session;
    }

    public LoanProduct get(long productId) {
        return null;
    }
}
