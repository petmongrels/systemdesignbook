package petmongrels.sdb.loan.domain;

import org.joda.money.Money;
import petmongrels.sdb.domain.Entity;

public class LoanFee extends Entity {
    private Money amount;

    public LoanFee(Money amount) {
        this.amount = amount;
    }
}
