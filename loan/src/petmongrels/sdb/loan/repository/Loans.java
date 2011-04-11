package petmongrels.sdb.loan.repository;

import org.hibernate.Session;
import petmongrels.sdb.infrastructure.hibernate.SessionRepository;
import petmongrels.sdb.loan.domain.Loan;

public class Loans {
    Session session;

    public Loans() {
        this(SessionRepository.getCurrentSession());
    }

    public Loans(Session session) {
        this.session = session;
    }

    public void add(Loan loan) {
    }
}
