package petmongrels.sdb.application.request;

import petmongrels.sdb.utility.primitives.ValidationErrors;

public class NewLoanResponse {
    public String loanNumber;
    ValidationErrors errors;

    public NewLoanResponse(ValidationErrors errors) {
        this.errors = errors;
    }

    public NewLoanResponse(String loanNumber) {
        this.loanNumber = loanNumber;
    }
}
