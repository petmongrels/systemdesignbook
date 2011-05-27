package petmongrels.sdb.container;

import petmongrels.sdb.customer.service.CustomerService;
import petmongrels.sdb.infrastructure.spring.ConventionBasedContextBuilder;
import petmongrels.sdb.loan.repository.AllLoans;
import petmongrels.sdb.loan.service.LoanService;
import petmongrels.sdb.product.service.ProductService;

public class ApplicationContainer {
    private ConventionBasedContextBuilder builder;

    public ApplicationContainer() {
        builder = new ConventionBasedContextBuilder();
    }

    public void defineBeans() {
        addBean(LoanService.class);
        addBean(ProductService.class);
        addBean(CustomerService.class);
        addBean(AllLoans.class);
    }

    private void addBean(Class beanClass) {
        builder.addBean(beanClass);
    }
}
