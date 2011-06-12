package petmongrels.sdb.loan.responsefactory;

import petmongrels.sdb.application.response.NewLoanResponse;
import petmongrels.sdb.loan.domain.LoanAccount;
import petmongrels.sdb.validation.ValidationErrors;

public class NewLoanResponseFactory {
    public static NewLoanResponse create(ValidationErrors errors) {
        return new NewLoanResponse(errors);
    }

    public static NewLoanResponse create(LoanAccount loanAccount) {
        return new NewLoanResponse(loanAccount.number());
    }
}
