package petmongrels.sdb.loan.domain;

import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.application.request.NewLoanRequest.*;

public class LoanAccountFactory {
    public LoanAccount newAccount(NewLoanRequest newLoanRequest) {
        LoanFees loanFees = new LoanFees();
        for(RequestedLoanFee requestedLoanFee : newLoanRequest.Fees) {
            LoanFee loanFee = new LoanFee(requestedLoanFee.Amount);
            loanFee.id(requestedLoanFee.FeeId);
            loanFees.add(loanFee);
        }
        LoanAccount loanAccount = LoanAccount.newLoan(newLoanRequest.LoanAmount, newLoanRequest.Interest, newLoanRequest.NumberOfInstallments, loanFees);
        loanAccount.customerId(newLoanRequest.CustomerId).productId(newLoanRequest.ProductId);
        return loanAccount;
    }
}
