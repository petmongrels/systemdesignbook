package petmongrels.sdb.product.utility;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.application.request.RequestedLoanFees;
import petmongrels.sdb.application.request.CreateLoanRequest;
import petmongrels.sdb.product.domain.LoanProductFee;
import petmongrels.sdb.product.domain.LoanProductFees;
import petmongrels.sdb.product.domain.value.DoubleRange;
import petmongrels.sdb.product.domain.value.MoneyRange;
import petmongrels.sdb.utility.primitives.LocalMoney;

import java.util.Arrays;

public class ProductValueObjectFactory {
    public MoneyRange moneyRange(int minimum, int maximum) {
        return new MoneyRange(minimum, maximum);
    }

    public DoubleRange doubleRange(double minimum, double maximum) {
        return new DoubleRange(minimum, maximum);
    }

    protected LocalDate date(int day, int month, int year) {
        return new LocalDate(year, month, day);
    }

    protected Money money(int amount) {
        return LocalMoney.of(amount);
    }

    protected RequestedLoanFees fees(CreateLoanRequest.RequestedLoanFee... fees) {
        RequestedLoanFees requestedLoanFees = new RequestedLoanFees();
        requestedLoanFees.addAll(Arrays.asList(fees));
        return requestedLoanFees;
    }

    protected DoubleRange numberOfInstallmentsRange(int minimum, int maximum) {
        return doubleRange(minimum, maximum);
    }

    protected DoubleRange interestRange(int minimum, int maximum) {
        return doubleRange(minimum, maximum);
    }

    protected MoneyRange amountRange(int minimum, int maximum) {
        return moneyRange(minimum, maximum);
    }

    protected CreateLoanRequest.RequestedLoanFee fee(long feeId, Money amount) {
        return new CreateLoanRequest.RequestedLoanFee(feeId, amount);
    }

    protected int numberOfInstallments(int count) {
        return count;
    }

    protected int interest(int rate) {
        return rate;
    }

    protected LoanProductFees productFees(LoanProductFee... fees) {
        LoanProductFees loanProductFees = new LoanProductFees();
        loanProductFees.addAll(Arrays.asList(fees));
        return loanProductFees;
    }

    protected LoanProductFee productFee(long feeId, Money minimum, Money maximum) {
        LoanProductFee loanProductFee = new LoanProductFee(minimum, maximum);
        loanProductFee.setId(feeId);
        return loanProductFee;
    }
}
