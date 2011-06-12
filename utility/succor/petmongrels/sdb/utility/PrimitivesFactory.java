package petmongrels.sdb.utility;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.primitives.LocalMoney;

public class PrimitivesFactory {
    public static LocalDate date(int day, int month, int year) {
        return new LocalDate(year, month, day);
    }

    public static Money minimum(int amount) {
        return LocalMoney.of(amount);
    }

    public static Money maximum(int amount) {
        return LocalMoney.of(amount);
    }
}
