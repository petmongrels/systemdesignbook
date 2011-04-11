package petmongrels.sdb.loan.responsefactory;

import petmongrels.sdb.application.request.NewLoanResponse;
import petmongrels.sdb.loan.domain.Loan;
import petmongrels.sdb.utility.primitives.ValidationErrors;

public class NewLoanResponseFactory {
    public static NewLoanResponse create(ValidationErrors errors) {
        return new NewLoanResponse(errors);
    }

    public static NewLoanResponse create(Loan loan) {
        return new NewLoanResponse(loan.getNumber());
    }
}
