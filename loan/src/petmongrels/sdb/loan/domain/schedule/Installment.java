package petmongrels.sdb.loan.domain.schedule;

import org.joda.money.Money;
import org.joda.time.LocalDate;

public class Installment {
    Money principal;
    Money interest;
    Money total;
    LocalDate on;

    public Installment(Money principal, Money interest, Money total, LocalDate on) {
        this.principal = principal;
        this.interest = interest;
        this.total = total;
        this.on = on;
    }
}
