package petmongrels.sdb.presentation.loan.request;

import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.utility.PrimitiveConverter;

public class NewLoanSummaryUserRequest {
    public String CustomerId;
    public String ProductId;
    public String LoanAmount;
    public String DisbursalDate;

    public NewLoanRequest convertTo(PrimitiveConverter primitiveConverter) {
        NewLoanRequest newLoanRequest = new NewLoanRequest();
        newLoanRequest.CustomerId = primitiveConverter.getLong("CustomerId", CustomerId);
        newLoanRequest.ProductId = primitiveConverter.getLong("ProductId", ProductId);
        newLoanRequest.LoanAmount = primitiveConverter.getMoney("LoanAmount", LoanAmount);
        newLoanRequest.DisbursalDate = primitiveConverter.getDate("DisbursalDate", DisbursalDate);
        return newLoanRequest;
    }
}
