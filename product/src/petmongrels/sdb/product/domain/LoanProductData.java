package petmongrels.sdb.product.domain;

import org.joda.money.Money;

public class LoanProductData {
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
