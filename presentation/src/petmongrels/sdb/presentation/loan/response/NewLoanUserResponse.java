package petmongrels.sdb.presentation.loan.response;

import petmongrels.sdb.application.request.NewLoanResponse;
import petmongrels.sdb.presentation.loan.request.NewLoanUserRequest;

public class NewLoanUserResponse {
    NewLoanUserRequest request;
    NewLoanResponse serviceResponse;

    private NewLoanUserResponse(NewLoanUserRequest request) {
        this.request = request;
    }

    public static NewLoanUserResponse requestInvalid(NewLoanUserRequest request) {
        return new NewLoanUserResponse(request);
    }

    public static NewLoanUserResponse fromServiceResponse(NewLoanUserRequest request, NewLoanResponse newLoanResponse) {
        NewLoanUserResponse userResponse = new NewLoanUserResponse(request);
        userResponse.serviceResponse = newLoanResponse;
        return userResponse;
    }
}
