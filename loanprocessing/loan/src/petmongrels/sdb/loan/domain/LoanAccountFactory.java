package petmongrels.sdb.loan.domain;

import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.application.request.NewLoanRequest.*;
import petmongrels.sdb.loan.domain.fees.LoanFee;
import petmongrels.sdb.loan.domain.fees.LoanFees;
import petmongrels.sdb.loan.domain.fees.OneTimeLoanFee;

public class LoanAccountFactory {
    public LoanAccount newAccount(NewLoanRequest newLoanRequest) {
        LoanFees loanFees = new LoanFees();
        for(RequestedLoanFee requestedLoanFee : newLoanRequest.Fees) {
            OneTimeLoanFee loanFee = new OneTimeLoanFee(requestedLoanFee.Amount);
            loanFee.id(requestedLoanFee.FeeId);
            loanFees.add(loanFee);
        }
        LoanAccount loanAccount = LoanAccount.newLoan(newLoanRequest.LoanAmount, newLoanRequest.Interest, newLoanRequest.NumberOfInstallments, loanFees);
        loanAccount.customerId(newLoanRequest.CustomerId).productId(newLoanRequest.ProductId);
        return loanAccount;
    }
}
