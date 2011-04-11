package petmongrels.sdb.loan.service;

import java.util.ArrayList;

public class LoanEventsListeners extends ArrayList<LoanEventsListener> implements LoanEventsListener {
    public void loanCreated(long loanId) {
        for(LoanEventsListener listener : this)
            listener.loanCreated(loanId);
    }
}
