package petmongrels.sdb.loan.domain.schedule;

import org.joda.money.Money;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class InstallmentPaymentSchedule {
    List<Installment> installments = new ArrayList<Installment>();

    public static InstallmentPaymentSchedule forNewLoan(Money amount, double interestRate, double numberOfInstallments, LocalDate startDate) {
        InstallmentPaymentSchedule schedule = new InstallmentPaymentSchedule();
        for (int i = 0; i < numberOfInstallments; i++) {
            Installment installment = new Installment(null, null, null, startDate);
            schedule.installments.add(installment);
        }
        return schedule;
    }

    public Money paymentMade() {
        return null;
    }

    public Money paymentRemaining() {
        return null;
    }

    public LocalDate scheduledEndDate() {
        return null;
    }
}
