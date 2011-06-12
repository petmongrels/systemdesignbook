package petmongrels.sdb.presentation.loan.validation;

import static petmongrels.sdb.customer.domain.CustomerErrors.CUSTOMER_INACTIVE;
import static petmongrels.sdb.product.domain.ProductErrors.DISBURSAL_DATE_BEFORE_PRODUCT_BECOMES_ACTIVE;
import static petmongrels.sdb.product.domain.ProductErrors.LOAN_AMOUNT_OUT_OF_RANGE;

public class LoanFlowErrors {
    public static String[] SummaryErrors = new String[]{DISBURSAL_DATE_BEFORE_PRODUCT_BECOMES_ACTIVE, LOAN_AMOUNT_OUT_OF_RANGE, CUSTOMER_INACTIVE};
}
