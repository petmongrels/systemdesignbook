package petmongrels.sdb.presentation;

import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.application.response.NewLoanResponse;
import petmongrels.sdb.loan.service.LoanService;
import petmongrels.sdb.presentation.loan.request.NewLoanSummaryUserRequest;
import petmongrels.sdb.presentation.loan.request.NewLoanUserRequest;
import petmongrels.sdb.presentation.loan.response.NewLoanSummaryUserResponse;
import petmongrels.sdb.presentation.loan.response.NewLoanUserResponse;
import petmongrels.sdb.utility.PrimitiveConverter;

public class NewLoanController {
    LoanService loanService;

    public NewLoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    public void preview() {
    }

    public NewLoanUserResponse create(NewLoanUserRequest request) {
        PrimitiveConverter primitiveConverter = new PrimitiveConverter();
        NewLoanRequest newLoanRequest = request.convertTo(primitiveConverter);
        if (primitiveConverter.foundErrors()) return NewLoanUserResponse.requestInvalid(request);
        NewLoanResponse newLoanResponse = loanService.create(newLoanRequest);
        return NewLoanUserResponse.fromServiceResponse(request, newLoanResponse);
    }

    public NewLoanSummaryUserResponse summary(NewLoanSummaryUserRequest request) {
        PrimitiveConverter primitiveConverter = new PrimitiveConverter();
        NewLoanRequest newLoanRequest = request.convertTo(primitiveConverter);
        if (primitiveConverter.foundErrors()) return NewLoanSummaryUserResponse.requestInvalid(request);
        NewLoanResponse newLoanResponse = loanService.create(newLoanRequest);
        return NewLoanSummaryUserResponse.fromServiceResponse(request, newLoanResponse);
    }
}
