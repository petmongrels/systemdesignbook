package petmongrels.sdb.product.domain;

import org.joda.money.Money;
import petmongrels.sdb.domain.Entity;

public class ExtrinsicLoanProduct extends Entity {
    Money defaultAmount;
    double defaultInterest;
    double defaultNumberOfInstallments;
    String fundName;

    public Money defaultAmount() {
        return defaultAmount;
    }

    public ExtrinsicLoanProduct defaultAmount(Money defaultAmount) {
        this.defaultAmount = defaultAmount;
        return this;
    }

    public double defaultInterest() {
        return defaultInterest;
    }

    public ExtrinsicLoanProduct defaultInterest(double defaultInterest) {
        this.defaultInterest = defaultInterest;
        return this;
    }

    public double defaultNumberOfInstallments() {
        return defaultNumberOfInstallments;
    }

    public ExtrinsicLoanProduct defaultNumberOfInstallments(double defaultNumberOfInstallments) {
        this.defaultNumberOfInstallments = defaultNumberOfInstallments;
        return this;
    }

    public String fundName() {
        return fundName;
    }

    public ExtrinsicLoanProduct fundName(String fundName) {
        this.fundName = fundName;
        return this;
    }
}