package petmongrels.sdb.product.domain.value;

import org.joda.money.Money;
import petmongrels.sdb.utility.primitives.LocalMoney;

public class MoneyRange {
    Money minimum;
    Money maximum;

    private MoneyRange() {
    }

    public MoneyRange(Money minimum, Money maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public MoneyRange(int minimum, int maximum) {
        this(LocalMoney.of(minimum), LocalMoney.of(minimum));
    }

    public boolean fallsWithin(Money amount) {
        return amount.isGreaterThan(minimum) && amount.isLessThan(maximum);
    }

    public boolean fallsOutside(Money amount) {
        return !fallsWithin(amount);
    }
}
