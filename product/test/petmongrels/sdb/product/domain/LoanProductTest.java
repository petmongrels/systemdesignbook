package petmongrels.sdb.product.domain;

import org.testng.Assert;
import org.testng.annotations.Test;
import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.validation.ValidationErrors;

import static petmongrels.sdb.product.ProductAttributes.*;
import static petmongrels.sdb.product.ProductFeeAttributes.*;
import static petmongrels.sdb.utility.PrimitivesFactory.*;

@Test
public class LoanProductTest {
    public void verifyTerms() {
        LoanProduct loanProduct = new LoanProduct(amountRange(100, 10000), interestRange(10, 20), numberOfInstallmentsRange(12, 24), effectiveFrom(2011, 1, 1),
                                                  productFees(productFee(1, minimum(10), maximum(20))));
        LoanTerms loanTerms = new LoanTerms(amount(100000), interest(15), numberOfInstallments(15), date(1, 2, 2011), fees(fee(1, amount(10))));
        ValidationErrors errors = loanProduct.verifyTerms(loanTerms);
        Assert.assertEquals(errors.size(), 1);
    }
}
