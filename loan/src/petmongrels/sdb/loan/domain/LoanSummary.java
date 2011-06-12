package petmongrels.sdb.loan.domain;

import org.joda.money.Money;
import org.joda.time.LocalDate;

public class LoanSummary {
    Money amount;
    Money paymentDone;
    double interestRate;
    Money paymentRemaining;
    LocalDate scheduledEndDate;

    public LoanSummary(Money amount, Money paymentDone, double interestRate, Money paymentRemaining, LocalDate scheduledEndDate) {
        this.amount = amount;
        this.paymentDone = paymentDone;
        this.interestRate = interestRate;
        this.paymentRemaining = paymentRemaining;
        this.scheduledEndDate = scheduledEndDate;
    }
}
