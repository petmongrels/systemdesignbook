package petmongrels.sdb.loan.domain;

import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.application.request.NewLoanRequest.*;

public class LoanFactory {
    public Loan newLoan(NewLoanRequest newLoanRequest) {
        LoanFees loanFees = new LoanFees();
        for(RequestedLoanFee requestedLoanFee : newLoanRequest.Fees) {
            LoanFee loanFee = new LoanFee(requestedLoanFee.Amount);
            loanFee.setId(requestedLoanFee.FeeId);
            loanFees.add(loanFee);
        }
        Loan loan = Loan.newLoan(newLoanRequest.LoanAmount, newLoanRequest.Interest, newLoanRequest.NumberOfInstallments, newLoanRequest.DisbursalDate, loanFees);
        loan.setCustomerId(newLoanRequest.CustomerId);
        loan.setProductId(newLoanRequest.ProductId);
        return loan;
    }
}
