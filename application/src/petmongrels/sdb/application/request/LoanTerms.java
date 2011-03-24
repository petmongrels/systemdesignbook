package petmongrels.sdb.application.request;

import org.joda.money.Money;
import org.joda.time.LocalDate;
import petmongrels.sdb.utility.domain.scalars.MeetingFrequency;

public class LoanTerms {
    public Money LoanAmount;
    public double Interest;
    public int NumberOfInstallments;
    public LocalDate DisbursalDate;
    public RequestedLoanFees Fees;
    public MeetingFrequency MeetingFrequency;

    protected LoanTerms() {
    }

    public LoanTerms(Money loanAmount, double interest, int numberOfInstallments, LocalDate disbursalDate, RequestedLoanFees fees) {
        LoanAmount = loanAmount;
        Interest = interest;
        NumberOfInstallments = numberOfInstallments;
        DisbursalDate = disbursalDate;
        Fees = fees;
    }
}
