package petmongrels.sdb.customer.domain;

import petmongrels.sdb.utility.domain.scalars.MeetingFrequency;
import petmongrels.sdb.utility.primitives.ValidationErrors;

public class Customer {
    boolean isActive;
    MeetingFrequency frequency;

    public ValidationErrors available(MeetingFrequency meetingFrequency) {
        ValidationErrors errors = new ValidationErrors();
        if (!isActive) errors.add(CustomerErrors.CUSTOMER_INACTIVE);
        if (meetingFrequency != frequency) errors.add(CustomerErrors.CUSTOMER_ON_DIFFERENT_SCHEDULE, frequency.toString());
        return errors;
    }
}
