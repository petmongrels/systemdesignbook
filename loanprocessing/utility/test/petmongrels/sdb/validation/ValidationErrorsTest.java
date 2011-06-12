package petmongrels.sdb.validation;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class ValidationErrorsTest {
    ValidationErrors validationErrors;

    @BeforeMethod
    public void setup() {
        validationErrors = new ValidationErrors();
        validationErrors.add("Foo").add("Bar").add("Baz");
    }

    public void keep() {
        Assert.assertEquals(validationErrors.keep(new String[] {"Foo"}).size(), 1);
    }

    public void keepOnlyExisting() {
        Assert.assertEquals(validationErrors.keep(new String[] {"Foo", "Quack"}).size(), 1);
    }
}
