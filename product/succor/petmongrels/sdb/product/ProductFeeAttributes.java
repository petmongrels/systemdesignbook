package petmongrels.sdb.product;

import org.joda.money.Money;
import petmongrels.sdb.primitives.LocalMoney;

public class ProductFeeAttributes {
    public static Money minimum(int amount) {
        return LocalMoney.of(amount);
    }

    public static Money maximum(int amount) {
        return LocalMoney.of(amount);
    }
}
