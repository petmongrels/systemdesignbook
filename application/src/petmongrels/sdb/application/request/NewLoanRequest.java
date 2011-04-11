package petmongrels.sdb.application.request;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.domain.Identifiable;

public class NewLoanRequest {
    public long CustomerId;
    public long ProductId;
    public Money LoanAmount;
    public double Interest;
    public int NumberOfInstallments;
    public LocalDate DisbursalDate;
    public long FundId;
    public String Purpose;
    public RequestedLoanFees Fees = new RequestedLoanFees();

    public static class RequestedLoanFee implements Identifiable {
        public long FeeId;
        public Money Amount;

        public RequestedLoanFee(long feeId, Money amount) {
            FeeId = feeId;
            Amount = amount;
        }

        public long getId() {
            return FeeId;
        }
    }

    public LoanTerms loanTerms() {
        return new LoanTerms(LoanAmount, Interest, NumberOfInstallments, DisbursalDate, Fees);
    }
}