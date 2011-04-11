package petmongrels.sdb.infrastructure.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class ConventionBasedContextBuilder {
    private GenericApplicationContext applicationContext;

    public ConventionBasedContextBuilder() {
        applicationContext = new GenericApplicationContext();
    }

    public void addBean(Class beanClass) {
        RootBeanDefinition beanDefinition = beanDefinition(beanClass);
        String beanName = beanName(beanClass);
        registerBean(beanDefinition, beanName);
    }

    public ApplicationContext getContext() {
        return applicationContext;
    }

    private void registerBean(BeanDefinition beanDefinition, String beanName) {
        applicationContext.registerBeanDefinition(beanName, beanDefinition);
    }

    private String beanName(Class beanClass) {
        String packageName = beanClass.getPackage().getName();
        String className = beanClass.getName().replaceFirst(packageName, "").substring(1);
        return className.substring(0, 1).toLowerCase() + className.substring(1);
    }

    private RootBeanDefinition beanDefinition(Class beanClass) {
        return new RootBeanDefinition(beanClass, AbstractBeanDefinition.AUTOWIRE_AUTODETECT);
    }
}