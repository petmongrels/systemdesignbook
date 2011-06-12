package petmongrels.sdb.loan.domain;

import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static petmongrels.sdb.loan.LoanAttributes.*;
import static petmongrels.sdb.product.LoanProductAttributes.*;
import static petmongrels.sdb.product.LoanProductAttributes.numberOfInstallments;

@Test
public class LoanAccountTest_WithoutMother {
    public void accountStatusOnDisbursal() {
        LoanAccount loanAccount = LoanAccount.newLoan(amount(1000), interest(10), numberOfInstallments(12), loanFees(recurringLoanFee(amount(10))));
        loanAccount.disburse();
        assertEquals(LoanAccountStatus.DISBURSED, loanAccount.status());
    }

    public void disburseLoanWithOneTimeAndRecurringFee() {
        LoanAccount loanAccount = LoanAccount.newLoan(amount(1000), interest(10), numberOfInstallments(12), loanFees(oneTimeLoanFee(amount(10)), recurringLoanFee(amount(10))));
        loanAccount.disburse();
        //asserts payment schedule
    }

    public void accountStatusOnCancellation() {
        LoanAccount loanAccount = LoanAccount.newLoan(amount(1000), interest(10), numberOfInstallments(12), loanFees(recurringLoanFee(amount(10))));
        loanAccount.cancel();
        assertEquals(LoanAccountStatus.CANCELLED, loanAccount.status());
    }

    @ExpectedExceptions(InvalidLoanStateException.class)
    public void cancelADisbursedLoan() {
        LoanAccount loanAccount = LoanAccount.newLoan(amount(1000), interest(10), numberOfInstallments(12), loanFees(recurringLoanFee(amount(10))));
        loanAccount.disburse();
        loanAccount.cancel();
    }

    public void missAnInstallment() {
        LoanAccount loanAccount = LoanAccount.newLoan(amount(1000), interest(10), numberOfInstallments(12), loanFees(recurringLoanFee(amount(10))));
        loanAccount.disburse();
        loanAccount.installmentMissed();
        assertEquals(LoanAccountStatus.IN_BAD_STANDING, loanAccount.status());
    }
}
