package petmongrels.sdb.product.domain;

import org.joda.money.Money;
import petmongrels.sdb.domain.Entity;

public class LoanProductData extends Entity {
    Money defaultAmount;
    double defaultInterest;
    double defaultNumberOfInstallments;

    public Money getDefaultAmount() {
        return defaultAmount;
    }

    public double getDefaultInterest() {
        return defaultInterest;
    }

    public double getDefaultNumberOfInstallments() {
        return defaultNumberOfInstallments;
    }
}
