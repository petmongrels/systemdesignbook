package petmongrels.sdb.product.utility;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.product.domain.value.DoubleRange;
import petmongrels.sdb.product.domain.value.MoneyRange;
import petmongrels.sdb.utility.primitives.LocalMoney;

public class ProductValueObjectFactory {
    public MoneyRange moneyRange(int minimum, int maximum) {
        return new MoneyRange(minimum, maximum);
    }

    public DoubleRange doubleRange(double minimum, double maximum) {
        return new DoubleRange(minimum, maximum);
    }

    protected LocalDate date(int day, int month, int year) {
        return new LocalDate(year, month, day);
    }

    protected Money money(int amount) {
        return LocalMoney.of(amount);
    }
}
