package petmongrels.sdb.customer.domain;

import petmongrels.sdb.customer.domain.valueObjects.CustomerAvailability;
import petmongrels.sdb.domain.scalars.MeetingFrequency;
import petmongrels.sdb.validation.ValidationErrors;

public class Customer {
    boolean isActive;
    CustomerAvailability availability;

    public Customer(boolean active, CustomerAvailability availability) {
        isActive = active;
        this.availability = availability;
    }

    public ValidationErrors available(MeetingFrequency meetingFrequency) {
        ValidationErrors errors = new ValidationErrors();
        if (!isActive) errors.add(CustomerErrors.CUSTOMER_INACTIVE);
        if (!availability.on(meetingFrequency)) errors.add(CustomerErrors.CUSTOMER_ON_DIFFERENT_SCHEDULE, availability.toString());
        return errors;
    }
}
