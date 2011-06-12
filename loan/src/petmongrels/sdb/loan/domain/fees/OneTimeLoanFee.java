package petmongrels.sdb.loan.domain.fees;

import org.joda.money.Money;
import petmongrels.sdb.domain.Entity;

public class OneTimeLoanFee extends Entity implements LoanFee {
    private Money amount;

    public OneTimeLoanFee(Money amount) {
        this.amount = amount;
    }
}
