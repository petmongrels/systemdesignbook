package petmongrels.sdb.product.domain;

import petmongrels.sdb.application.request.RequestedLoanFees;
import petmongrels.sdb.domain.Identities;

import java.util.ArrayList;

import static petmongrels.sdb.application.request.NewLoanRequest.RequestedLoanFee;

public class LoanProductFees extends ArrayList<LoanProductFee> {
    public boolean supports(RequestedLoanFees fees) {
        Identities<RequestedLoanFee> requestedFeeIds = new Identities<RequestedLoanFee>(fees);
        Identities<RequestedLoanFee> ids = new Identities<RequestedLoanFee>(fees);
        return ids.contains(requestedFeeIds);
    }
}
