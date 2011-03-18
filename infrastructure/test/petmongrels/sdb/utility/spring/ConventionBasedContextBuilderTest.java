package petmongrels.sdb.utility.spring;

import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ConventionBasedContextBuilderTest {
    public void addBean() {
        ConventionBasedContextBuilder builder = new ConventionBasedContextBuilder();
        builder.addBean(TestBeanForConventionBasedContextBuilder.class);
        ApplicationContext applicationContext = builder.getContext();
        Assert.assertTrue(applicationContext.containsBean("testBeanForConventionBasedContextBuilder"),
                applicationContext.getBeanNamesForType(TestBeanForConventionBasedContextBuilder.class)[0]);
    }
}
