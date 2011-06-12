package petmongrels.sdb.loan.domain;

public class LoanAccountObjectMother {
    public static LoanAccount aDisbursedLoan() {
        LoanAccount loanAccount = LoanAccountMother.disbursedLoan();
        return populateExtrinsicFields(loanAccount);
    }

    private static LoanAccount populateExtrinsicFields(LoanAccount loanAccount) {
        loanAccount.number("IL0001").purposeOfLoan("Agriculture").notes("for seeds");
        return loanAccount;
    }

    public static LoanAccount aLoan() {
        LoanAccount loanAccount = LoanAccountMother.simpleLoan();
        return populateExtrinsicFields(loanAccount);
    }
}
