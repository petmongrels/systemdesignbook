package petmongrels.sdb.utility.spring;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ConventionBasedContextBuilder {
    private GenericApplicationContext applicationContext;

    public ConventionBasedContextBuilder() {
        applicationContext = new GenericApplicationContext();
    }

    public void addBean(Class beanClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(beanClass);
        String packageName = beanClass.getPackage().getName();
        String className = beanClass.getName().replaceFirst(packageName, "").substring(1);
        String beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
        applicationContext.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }

    public ApplicationContext getContext() {
        return applicationContext;
    }
}
