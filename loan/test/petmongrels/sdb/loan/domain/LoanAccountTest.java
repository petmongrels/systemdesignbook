package petmongrels.sdb.loan.domain;

import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static petmongrels.sdb.loan.LoanAttributes.*;
import static petmongrels.sdb.loan.domain.LoanAccountMother.disbursedLoan;
import static petmongrels.sdb.loan.domain.LoanAccountMother.simpleLoan;
import static petmongrels.sdb.product.LoanProductAttributes.amount;

@Test
public class LoanAccountTest {
    public void accountStatusOnDisbursal() {
        LoanAccount loanAccount = disbursedLoan();
        assertEquals(LoanAccountStatus.DISBURSED, loanAccount.status());
    }

    public void disburseLoanWithOneTimeAndRecurringFee() {
        LoanAccount loanAccount = simpleLoan(loanFees(oneTimeLoanFee(amount(10)), recurringLoanFee(amount(10))));
        loanAccount.disburse();
        //asserts payment schedule
    }

    public void accountStatusOnCancellation() {
        LoanAccount loanAccount = simpleLoan();
        loanAccount.cancel();
        assertEquals(LoanAccountStatus.CANCELLED, loanAccount.status());
    }

    @ExpectedExceptions(InvalidLoanStateException.class)
    public void cancelADisbursedLoan() {
        LoanAccount loanAccount = disbursedLoan();
        loanAccount.cancel();
    }

    public void missAnInstallment() {
        LoanAccount loanAccount = disbursedLoan();
        loanAccount.installmentMissed();
        assertEquals(LoanAccountStatus.IN_BAD_STANDING, loanAccount.status());
    }
}
