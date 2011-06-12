package petmongrels.sdb.utility;

import org.joda.money.Money;
import org.joda.money.MoneyException;
import org.joda.time.LocalDate;
import petmongrels.sdb.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveConverter {
    List<ValidationError> errors = new ArrayList<ValidationError>();

    public long getLong(String name, String s) {
        return getLong(ValidationError.NoIndex, name, s);
    }

    public long getLong(int index, String name, String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            addError(index, name, s);
        }
        return 0;
    }

    public LocalDate getDate(String name, String s) {
        return getDate(ValidationError.NoIndex, name, s);
    }

    public LocalDate getDate(int index, String name, String s) {
        try {
            return new LocalDate(s);
        } catch (NumberFormatException e) {
            addError(index, name, s);
        }
        return null;
    }

    public Money getMoney(String name, String s) {
        return getMoney(ValidationError.NoIndex, name, s);
    }

    public Money getMoney(int index, String name, String s) {
        try {
            Money.parse(s);
        } catch (MoneyException e) {
            addError(index, name, s);
        }
        return null;
    }

    public double getDouble(String name, String s) {
        return getDouble(ValidationError.NoIndex, name, s);
    }

    public double getDouble(int index, String name, String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            addError(index, name, s);
        }
        return 0;
    }

    public int getInt(String name, String s) {
        return getInt(ValidationError.NoIndex, name, s);
    }

    public int getInt(int index, String name, String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            addError(index, name, s);
        }
        return 0;
    }

    public boolean foundErrors() {
        return errors.size() != 0;
    }

    private void addError(int index, String name, String s) {
        errors.add(new ValidationError(index, name, s));
    }
}