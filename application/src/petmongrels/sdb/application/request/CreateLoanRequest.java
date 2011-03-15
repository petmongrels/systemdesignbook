package petmongrels.sdb.application.request;

import org.joda.money.Money;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class CreateLoanRequest {
    public long CustomerId;
    public long ProductId;
    public Money LoanAmount;
    public double Interest;
    public int NumberOfInstallments;
    public LocalDate DisbursalDate;
    public long FundId;
    public String Purpose;
    public List<Fee> LoanFees = new ArrayList<Fee>();

    public class Fee {
        public long FeeId;
        public Money Amount;
    }

    public LoanTerms loanTerms() {
        return new LoanTerms(LoanAmount, Interest, NumberOfInstallments, DisbursalDate);
    }
}
