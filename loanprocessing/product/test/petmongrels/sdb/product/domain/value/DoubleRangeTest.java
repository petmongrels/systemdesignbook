package petmongrels.sdb.product.domain.value;

import org.testng.Assert;
import org.testng.annotations.Test;
import petmongrels.sdb.primitives.DoubleRange;

@Test
public class DoubleRangeTest {
    public void fallsWithin() {
        DoubleRange range = new DoubleRange(400.00, 1000.00);
        Assert.assertEquals(true, range.fallsWithin(500.00));
        Assert.assertEquals(false, range.fallsWithin(100.00));
        Assert.assertEquals(false, range.fallsWithin(1100.00));
    }
}
