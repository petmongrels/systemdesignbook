package petmongrels.sdb.utility.primitives;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;

public class LocalMoney {
    public static Money of(int amount) {
        return Money.of(CurrencyUnit.ofCountry("IN"), new BigDecimal(amount));
    }
}
