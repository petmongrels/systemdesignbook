package petmongrels.sdb.loan.domain.fees;

import org.joda.money.Money;
import petmongrels.sdb.domain.Entity;

public class RecurringLoanFee extends Entity implements LoanFee {
    private Money amount;

    public RecurringLoanFee(Money amount) {
        this.amount = amount;
    }
}
