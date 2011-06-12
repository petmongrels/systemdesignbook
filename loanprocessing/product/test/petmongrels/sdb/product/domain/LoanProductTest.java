package petmongrels.sdb.product.domain;

import org.joda.time.LocalDate;
import org.testng.Assert;
import org.testng.annotations.Test;
import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.application.request.NewLoanRequest;
import petmongrels.sdb.application.request.NewLoanRequestAttributes;
import petmongrels.sdb.application.request.RequestedLoanFees;
import petmongrels.sdb.primitives.DoubleRange;
import petmongrels.sdb.primitives.LocalMoney;
import petmongrels.sdb.primitives.MoneyRange;
import petmongrels.sdb.validation.ValidationErrors;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static petmongrels.sdb.domain.EntityAttributes.id;
import static petmongrels.sdb.product.LoanProductAttributes.*;
import static petmongrels.sdb.utility.PrimitivesFactory.*;

@Test
public class LoanProductTest {
    public void verifyTerms() {
        LoanProduct loanProduct = new LoanProduct(amountRange(100, 10000), interestRange(10, 20), numberOfInstallmentsRange(12, 24), effectiveFrom(2011, 1, 1),
                                                  productFees(productFee(id(1), minimum(10), maximum(20))));
        LoanTerms loanTerms = new LoanTerms(amount(100000), interest(15), numberOfInstallments(15), date(1, 2, 2011), NewLoanRequestAttributes.fees(fee(id(1), amount(10))));
        ValidationErrors errors = loanProduct.verifyTerms(loanTerms);
        assertEquals(errors.size(), 1);
    }

    public void verifyTerms_() {
        LoanProductFees loanProductFees = new LoanProductFees();
        LoanProductFee loanProductFee = new LoanProductFee(LocalMoney.of(10), LocalMoney.of(20));
        loanProductFee.id(1);
        loanProductFees.addAll(Arrays.asList(loanProductFee));

        LoanProduct loanProduct = new LoanProduct(new MoneyRange(100, 10000), new DoubleRange(10, 20), new DoubleRange(12, 24), new LocalDate(2011, 1, 1),
                loanProductFees);

        RequestedLoanFees requestedLoanFees = new RequestedLoanFees();
        requestedLoanFees.addAll(Arrays.asList(new NewLoanRequest.RequestedLoanFee(1, LocalMoney.of(10))));

        LoanTerms loanTerms = new LoanTerms(LocalMoney.of(100000), 15, 15, new LocalDate(2011, 2, 1), requestedLoanFees);
        ValidationErrors errors = loanProduct.verifyTerms(loanTerms);
        Assert.assertEquals(errors.size(), 1);
    }
}