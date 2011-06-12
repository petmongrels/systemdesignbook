package petmongrels.sdb.loan.domain;

import petmongrels.sdb.loan.domain.fees.LoanFees;

import static petmongrels.sdb.loan.LoanAttributes.*;
import static petmongrels.sdb.product.LoanProductAttributes.*;

public class LoanAccountMother {
    public static LoanAccount simpleLoan() {
        return simpleLoan(loanFees(recurringLoanFee(amount(10))));
    }

    public static LoanAccount simpleLoan(LoanFees loanFees) {
        return LoanAccount.newLoan(amount(1000), interest(10), numberOfInstallments(12), loanFees);
    }

    public static LoanAccount disbursedLoan() {
        LoanAccount loanAccount = simpleLoan();
        loanAccount.disburse();
        return loanAccount;
    }
}
