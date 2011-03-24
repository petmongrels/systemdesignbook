package petmongrels.sdb.product.domain;

import org.joda.money.Money;
import petmongrels.sdb.domain.Entity;

public class LoanProductFee extends Entity {
    Money minimum;
    Money maximum;

    public LoanProductFee(Money minimum, Money maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
