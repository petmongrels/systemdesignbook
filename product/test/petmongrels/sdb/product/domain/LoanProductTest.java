package petmongrels.sdb.product.domain;

import org.testng.Assert;
import org.testng.annotations.Test;
import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.product.utility.ProductValueObjectFactory;

import java.util.List;

@Test
public class LoanProductTest extends ProductValueObjectFactory {
    public void verifyTerms() {
        LoanProduct loanProduct = new LoanProduct(moneyRange(100, 10000), doubleRange(10, 20), doubleRange(12, 24), date(1, 1, 2011));
        LoanTerms loanTerms = new LoanTerms(money(100000), 15, 15, date(1, 2, 2011));
        List<String> errors = loanProduct.verifyTerms(loanTerms);
        Assert.assertEquals(1, errors.size());
    }
}
