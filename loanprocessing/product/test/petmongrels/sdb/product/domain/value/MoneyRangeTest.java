package petmongrels.sdb.product.domain.value;

import org.testng.Assert;
import org.testng.annotations.Test;
import petmongrels.sdb.primitives.LocalMoney;
import petmongrels.sdb.primitives.MoneyRange;

@Test
public class MoneyRangeTest {
    public void fallsWithin() {
        MoneyRange range = new MoneyRange(LocalMoney.of(40000), LocalMoney.of(100000));
        Assert.assertEquals(true, range.fallsWithin(LocalMoney.of(50000)));
        Assert.assertEquals(false, range.fallsWithin(LocalMoney.of(10000)));
        Assert.assertEquals(false, range.fallsWithin(LocalMoney.of(110000)));
    }
}
