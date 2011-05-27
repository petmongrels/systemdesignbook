package petmongrels.sdb.utility;

import org.joda.time.LocalDate;

public class PrimitivesFactory {
    public static LocalDate date(int day, int month, int year) {
        return new LocalDate(year, month, day);
    }
}
