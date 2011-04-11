package petmongrels.sdb.loan.domain;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.loan.domain.schedule.InstallmentPaymentSchedule;

public class Loan extends LoanData {
    Money amount;
    double interestRate;
    double numberOfInstallments;
    LocalDate startDate;
    LoanFees fees;
    InstallmentPaymentSchedule schedule;

    private Loan() {
    }

    public static Loan newLoan(Money amount, double interestRate, double numberOfInstallments, LocalDate startDate, LoanFees fees) {
        Loan loan = new Loan();
        loan.amount = amount;
        loan.interestRate = interestRate;
        loan.numberOfInstallments = numberOfInstallments;
        loan.startDate = startDate;
        loan.fees = fees;
        loan.schedule = InstallmentPaymentSchedule.forNewLoan(amount, interestRate, numberOfInstallments, startDate);
        return loan;
    }
}
