package petmongrels.sdb.application.request;

import org.joda.money.Money;
import org.joda.time.LocalDate;

public class LoanTerms {
    public Money LoanAmount;
    public double Interest;
    public int NumberOfInstallments;
    public LocalDate DisbursalDate;

    public LoanTerms(Money loanAmount, double interest, int numberOfInstallments, LocalDate disbursalDate) {
        LoanAmount = loanAmount;
        Interest = interest;
        NumberOfInstallments = numberOfInstallments;
        DisbursalDate = disbursalDate;
    }
}
