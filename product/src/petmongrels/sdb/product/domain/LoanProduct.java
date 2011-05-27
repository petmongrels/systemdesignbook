package petmongrels.sdb.product.domain;

import org.joda.time.LocalDate;
import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.primitives.DoubleRange;
import petmongrels.sdb.primitives.MoneyRange;
import petmongrels.sdb.validation.ValidationErrors;

import static petmongrels.sdb.product.domain.ProductErrors.*;

public class LoanProduct extends LoanProductData {
    MoneyRange loanAmountRange;
    DoubleRange interestRange;
    DoubleRange numberOfInstallmentsRange;
    LocalDate effectiveFrom;
    LoanProductFees fees;

    public LoanProduct(MoneyRange loanAmountRange, DoubleRange interestRange, DoubleRange numberOfInstallmentsRange, LocalDate effectiveFrom, LoanProductFees fees) {
        this.loanAmountRange = loanAmountRange;
        this.interestRange = interestRange;
        this.numberOfInstallmentsRange = numberOfInstallmentsRange;
        this.effectiveFrom = effectiveFrom;
        this.fees = fees;
    }

    public ValidationErrors verifyTerms(LoanTerms loanTerms) {
        ValidationErrors errors = new ValidationErrors();
        if(loanAmountRange.fallsOutside(loanTerms.LoanAmount)) errors.add(LOAN_AMOUNT_OUT_OF_RANGE);
        if(interestRange.fallsOutside(loanTerms.Interest)) errors.add(LOAN_INTEREST_RATE_OUT_OF_RANGE);
        if(numberOfInstallmentsRange.fallsOutside(loanTerms.NumberOfInstallments)) errors.add(NUMBER_OF_INSTALLMENTS_OUT_OF_RANGE);
        if(loanTerms.DisbursalDate.isBefore(effectiveFrom)) errors.add(DISBURSAL_DATE_BEFORE_PRODUCT_BECOMES_ACTIVE);
        if(!fees.supports(loanTerms.Fees)) errors.add(FEES_NOT_SUPPORTED_BY_THIS_PRODUCT);
        return errors;
    }
}
