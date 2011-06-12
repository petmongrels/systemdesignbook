package petmongrels.sdb.loan.service;

public interface LoanEventsListener {
    void loanCreated(long loanId);
}
