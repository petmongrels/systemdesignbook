package petmongrels.sdb.customer.service;

import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.customer.domain.Customer;
import petmongrels.sdb.customer.repository.Customers;
import petmongrels.sdb.utility.primitives.ValidationErrors;

public class CustomerService {
    private Customers customers;

    public CustomerService(Customers customers) {
        this.customers = customers;
    }

    public ValidationErrors verifyNewLoanTerms(long customerId, LoanTerms loanTerms) {
        Customer customer = customers.get(customerId);
        return customer.available(loanTerms.MeetingFrequency);
    }
}
