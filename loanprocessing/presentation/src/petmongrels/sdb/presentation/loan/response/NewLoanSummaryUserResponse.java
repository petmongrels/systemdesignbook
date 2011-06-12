package petmongrels.sdb.presentation.loan.response;

import petmongrels.sdb.application.response.NewLoanResponse;
import petmongrels.sdb.presentation.loan.request.NewLoanSummaryUserRequest;
import petmongrels.sdb.presentation.loan.validation.LoanFlowErrors;

public class NewLoanSummaryUserResponse {
    NewLoanSummaryUserRequest request;
    NewLoanResponse serviceResponse;

    private NewLoanSummaryUserResponse(NewLoanSummaryUserRequest request) {
        this.request = request;
    }

    public static NewLoanSummaryUserResponse requestInvalid(NewLoanSummaryUserRequest request) {
        return new NewLoanSummaryUserResponse(request);
    }

    public static NewLoanSummaryUserResponse fromServiceResponse(NewLoanSummaryUserRequest request, NewLoanResponse newLoanResponse) {
        NewLoanSummaryUserResponse response = new NewLoanSummaryUserResponse(request);
        newLoanResponse.Errors.keep(LoanFlowErrors.SummaryErrors);
        response.serviceResponse = newLoanResponse;
        return null;
    }
}
