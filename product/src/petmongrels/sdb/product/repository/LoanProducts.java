package petmongrels.sdb.product.repository;

import org.hibernate.Session;
import petmongrels.sdb.infrastructure.hibernate.SessionRepository;
import petmongrels.sdb.product.domain.LoanProduct;

public class LoanProducts {
    Session session;

    public LoanProducts() {
        this(SessionRepository.getCurrentSession());
    }

    public LoanProducts(Session session) {
        this.session = session;
    }

    public LoanProduct get(long productId) {
        return null;
    }
}
