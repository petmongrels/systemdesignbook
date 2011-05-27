package petmongrels.sdb.loan.domain;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.loan.domain.schedule.InstallmentPaymentSchedule;

public class LoanAccount extends ExtrinsicLoan {
    Money amount;
    double interestRate;
    double numberOfInstallments;
    LoanFees fees;
    InstallmentPaymentSchedule schedule;
    LocalDate disbursementDate;

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

    public void disburse(LocalDate date) {
        this.disbursementDate = date;
        schedule = InstallmentPaymentSchedule.forNewLoan(amount, interestRate, numberOfInstallments, date);
    }
}
