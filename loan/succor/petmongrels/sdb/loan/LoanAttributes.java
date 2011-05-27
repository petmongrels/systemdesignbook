package petmongrels.sdb.loan;

import org.joda.money.Money;
import petmongrels.sdb.loan.domain.LoanFees;
import petmongrels.sdb.primitives.LocalMoney;

public class LoanAttributes {
    public static double numberOfInstallments(double value) {
        return value;
    }

    public static double interest(int value) {
        return value;
    }

    public static LoanFees fees() {
        return new LoanFees();
    }
}
