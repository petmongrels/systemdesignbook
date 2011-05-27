package petmongrels.sdb.loan.repository;

import org.hibernate.Session;
import petmongrels.sdb.infrastructure.hibernate.SessionRepository;
import petmongrels.sdb.loan.domain.LoanAccount;
import petmongrels.sdb.loan.domain.LoanAccount;

public class AllLoans {
    Session session;

    public AllLoans() {
        this(SessionRepository.getCurrentSession());
    }

    public AllLoans(Session session) {
        this.session = session;
    }

    public void add(LoanAccount loanAccount) {
    }
}
