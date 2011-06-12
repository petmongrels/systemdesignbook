package petmongrels.sdb.product;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.primitives.DoubleRange;
import petmongrels.sdb.primitives.LocalMoney;
import petmongrels.sdb.primitives.MoneyRange;
import petmongrels.sdb.product.domain.LoanProductFee;
import petmongrels.sdb.product.domain.LoanProductFees;

import java.util.Arrays;

public class LoanProductAttributes {
    public static DoubleRange numberOfInstallmentsRange(int minimum, int maximum) {
        return new DoubleRange(minimum, maximum);
    }

    public static DoubleRange interestRange(int minimum, int maximum) {
        return new DoubleRange(minimum, maximum);
    }

    public static MoneyRange amountRange(int minimum, int maximum) {
        return new MoneyRange(minimum, maximum);
    }

    public static NewLoanRequest.RequestedLoanFee fee(long feeId, Money amount) {
        return new NewLoanRequest.RequestedLoanFee(feeId, amount);
    }

    public static int numberOfInstallments(int count) {
        return count;
    }

    public static double interest(int rate) {
        return rate;
    }

    public static double interest(double rate) {
        return rate;
    }

    public static LoanProductFees productFees(LoanProductFee... fees) {
        LoanProductFees loanProductFees = new LoanProductFees();
        loanProductFees.addAll(Arrays.asList(fees));
        return loanProductFees;
    }

    public static LoanProductFee productFee(long feeId, Money minimum, Money maximum) {
        LoanProductFee loanProductFee = new LoanProductFee(minimum, maximum);
        loanProductFee.id(feeId);
        return loanProductFee;
    }

    public static LocalDate effectiveFrom(int year, int month, int day) {
        return new LocalDate(year, month, day);
    }

    public static Money amount(int amount) {
        return LocalMoney.of(amount);
    }
}
