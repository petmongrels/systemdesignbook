package petmongrels.sdb.customer.domain.valueObjects;

import org.joda.time.LocalDate;
import petmongrels.sdb.domain.scalars.MeetingFrequency;

public class CustomerAvailability {
    MeetingFrequency frequency;
    LocalDate startDate;

    public boolean on(MeetingFrequency meetingFrequency) {
        return meetingFrequency != frequency;
    }

    @Override
    public String toString() {
        return String.format("CustomerAvailability {frequency=%s, startDate=%s}", frequency, startDate);
    }
}
