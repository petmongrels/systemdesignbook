package petmongrels.sdb.product.domain;

import org.testng.Assert;
import org.testng.annotations.Test;
import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.product.utility.ProductValueObjectFactory;
import petmongrels.sdb.utility.primitives.ValidationErrors;

@Test
public class LoanProductTest extends ProductValueObjectFactory {
    public void verifyTerms() {
        LoanProduct loanProduct = new LoanProduct(amountRange(100, 10000), interestRange(10, 20), numberOfInstallmentsRange(12, 24), date(1, 1, 2011), productFees(productFee(1, money(10), money(20))));
        LoanTerms loanTerms = new LoanTerms(money(100000), interest(15), numberOfInstallments(15), date(1, 2, 2011), fees(fee(1, money(10))));
        ValidationErrors errors = loanProduct.verifyTerms(loanTerms);
        Assert.assertEquals(errors.size(), 1);
    }
}
