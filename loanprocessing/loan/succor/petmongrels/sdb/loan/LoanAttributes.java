package petmongrels.sdb.loan;

import org.joda.money.Money;
import petmongrels.sdb.loan.domain.fees.LoanFee;
import petmongrels.sdb.loan.domain.fees.LoanFees;
import petmongrels.sdb.loan.domain.fees.OneTimeLoanFee;
import petmongrels.sdb.loan.domain.fees.RecurringLoanFee;

public class LoanAttributes {
    public static double numberOfInstallments(double value) {
        return value;
    }

    public static LoanFees loanFees(LoanFee... loanFees) {
        return new LoanFees();
    }

    public static LoanFee recurringLoanFee(Money money) {
        return new RecurringLoanFee(money);
    }

    public static LoanFee oneTimeLoanFee(Money money) {
        return new OneTimeLoanFee(money);
    }
}
