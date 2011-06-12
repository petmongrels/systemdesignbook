package petmongrels.sdb.customer.service;

import petmongrels.sdb.application.request.LoanTerms;
import petmongrels.sdb.customer.domain.Customer;
import petmongrels.sdb.customer.domain.valueObjects.CustomerAvailability;
import petmongrels.sdb.customer.repository.AllCustomers;
import petmongrels.sdb.domain.scalars.MeetingFrequency;
import petmongrels.sdb.validation.ValidationErrors;

public class CustomerService {
    private AllCustomers allCustomers;

    public CustomerService() {
        this(new AllCustomers());
    }

    public CustomerService(AllCustomers allCustomers) {
        this.allCustomers = allCustomers;
    }

    public ValidationErrors verifyNewLoanTerms(long customerId, LoanTerms loanTerms) {
        Customer customer = allCustomers.get(customerId);
        return customer.available(loanTerms.MeetingFrequency);
    }

    public CustomerAvailability meetingSchedule(long customerId) {
        return null;
    }
}
