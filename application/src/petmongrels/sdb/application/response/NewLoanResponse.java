package petmongrels.sdb.application.response;

import petmongrels.sdb.validation.ValidationErrors;

public class NewLoanResponse extends ServiceResponse {
    public String LoanNumber;

    public NewLoanResponse(ValidationErrors errors) {
        super(errors);
    }

    public NewLoanResponse(String loanNumber) {
        this.LoanNumber = loanNumber;
    }
}
