package petmongrels.sdb.application.request;

import java.util.Arrays;

public class NewLoanRequestAttributes {
    public static RequestedLoanFees fees(NewLoanRequest.RequestedLoanFee... fees) {
        RequestedLoanFees requestedLoanFees = new RequestedLoanFees();
        requestedLoanFees.addAll(Arrays.asList(fees));
        return requestedLoanFees;
    }
}
