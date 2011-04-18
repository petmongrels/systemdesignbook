package petmongrels.sdb.presentation.loan.request;

import org.joda.money.Money;
import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.utility.PrimitiveConverter;

import java.util.ArrayList;
import java.util.List;

import static petmongrels.sdb.application.request.NewLoanRequest.RequestedLoanFee;

public class NewLoanUserRequest {
    public NewLoanSummaryUserRequest SummaryUserRequest = new NewLoanSummaryUserRequest();

    public String Interest;
    public String NumberOfInstallments;
    public String FundId;
    public String Purpose;
    public List<LoanFeeUserRequest> Fees = new ArrayList<LoanFeeUserRequest>();

    public NewLoanRequest convertTo(PrimitiveConverter primitiveConverter) {
        NewLoanRequest newLoanRequest = SummaryUserRequest.convertTo(primitiveConverter);
        newLoanRequest.Interest = primitiveConverter.getDouble("Interest", Interest);
        newLoanRequest.NumberOfInstallments = primitiveConverter.getInt("NumberOfInstallments", NumberOfInstallments);
        newLoanRequest.FundId = primitiveConverter.getLong("FundId", FundId);
        newLoanRequest.Purpose = Purpose;

        int i = 0;
        for (LoanFeeUserRequest feeUserRequest : Fees) {
            long feeId = primitiveConverter.getLong(i, "FeeId", feeUserRequest.FeeId);
            Money amount = primitiveConverter.getMoney(i, "FeeAmount", feeUserRequest.FeeId);
            newLoanRequest.Fees.add(new RequestedLoanFee(feeId, amount));
            i++;
        }
        return newLoanRequest;
    }
}
