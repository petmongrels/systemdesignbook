package petmongrels.sdb.utility.spring;

import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import petmongrels.sdb.infrastructure.spring.ConventionBasedContextBuilder;

@Test
public class ConventionBasedContextBuilderTest {
    ConventionBasedContextBuilder builder;
    ApplicationContext applicationContext;

    @BeforeMethod
    public void setup() {
        builder = new ConventionBasedContextBuilder();
        applicationContext = builder.getContext();
    }

    public void addBean() {
        builder.addBean(TestBeanForConventionBasedContextBuilder.class);
        builder.addBean(TestDependeeBeanForConventionBasedContextBuilder.class);
        Assert.assertNotNull(applicationContext.getBean("testDependeeBeanForConventionBasedContextBuilder"));

        String beanName = "testBeanForConventionBasedContextBuilder";
        Assert.assertTrue(applicationContext.containsBean(beanName), applicationContext.getBeanNamesForType(TestBeanForConventionBasedContextBuilder.class)[0]);
        Assert.assertNotNull(applicationContext.getBean(beanName));
    }
}
