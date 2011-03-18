package petmongrels.sdb.product.domain;

import org.joda.time.LocalDate;
import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.product.domain.value.DoubleRange;
import petmongrels.sdb.product.domain.value.MoneyRange;

import java.util.ArrayList;
import java.util.List;

public class LoanProduct extends LoanProductData {
    MoneyRange loanAmountRange;
    DoubleRange interestRange;
    DoubleRange numberOfInstallmentsRange;
    LocalDate effectiveFrom;

    public LoanProduct(MoneyRange loanAmountRange, DoubleRange interestRange, DoubleRange numberOfInstallmentsRange, LocalDate effectiveFrom) {
        this.loanAmountRange = loanAmountRange;
        this.interestRange = interestRange;
        this.numberOfInstallmentsRange = numberOfInstallmentsRange;
        this.effectiveFrom = effectiveFrom;
    }

    public List<String> verifyTerms(LoanTerms loanTerms) {
        List<String> errors = new ArrayList<String>();
        if(loanAmountRange.fallsOutside(loanTerms.LoanAmount)) errors.add(ProductErrors.LOAN_AMOUNT_OUT_OF_RANGE);
        if(interestRange.fallsOutside(loanTerms.Interest)) errors.add(ProductErrors.LOAN_INTEREST_RATE_OUT_OF_RANGE);
        if(numberOfInstallmentsRange.fallsOutside(loanTerms.NumberOfInstallments)) errors.add(ProductErrors.NUMBER_OF_INSTALLMENTS_OUT_OF_RANGE);
        if(loanTerms.DisbursalDate.isBefore(effectiveFrom)) errors.add(ProductErrors.DISBURSAL_DATE_BEFORE_PRODUCT_BECOMES_ACTIVE);
        return errors;
    }
}
