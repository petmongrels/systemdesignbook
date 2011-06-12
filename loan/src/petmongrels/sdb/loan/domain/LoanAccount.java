package petmongrels.sdb.loan.domain;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.loan.domain.fees.LoanFees;
import petmongrels.sdb.loan.domain.schedule.InstallmentPaymentSchedule;

public class LoanAccount extends ExtrinsicLoan {
    Money amount;
    double interestRate;
    double numberOfInstallments;
    LoanFees fees;
    InstallmentPaymentSchedule schedule;
    LocalDate disbursementDate;
    LoanAccountStatus status;

    private LoanAccount() {
    }

    public static LoanAccount newLoan(Money amount, double interestRate, double numberOfInstallments, LoanFees fees) {
        LoanAccount loanAccount = new LoanAccount();
        loanAccount.amount = amount;
        loanAccount.interestRate = interestRate;
        loanAccount.numberOfInstallments = numberOfInstallments;
        loanAccount.fees = fees;
        return loanAccount;
    }

    public LoanAccount cancel() {
        if (status == LoanAccountStatus.DISBURSED)
            throw new InvalidLoanStateException(String.format("This loan was disbursed on %s, hence cannot be cancelled", disbursementDate));
        status = LoanAccountStatus.CANCELLED;
        return this;
    }

    public LoanAccount disburse() {
        this.disbursementDate = new LocalDate();
        schedule = InstallmentPaymentSchedule.forNewLoan(amount, interestRate, numberOfInstallments, disbursementDate);
        status = LoanAccountStatus.DISBURSED;
        return this;
    }

    public LoanAccount pay(LocalDate date, Money amount) {
        return this;
    }

    public LoanAccount installmentMissed() {
        return this;
    }

    public LoanAccountStatus status() {
        return status;
    }

    public LoanSummary summary() {
        return new LoanSummary(amount, schedule.paymentMade(), interestRate, schedule.paymentRemaining(), schedule.scheduledEndDate());
    }
}
