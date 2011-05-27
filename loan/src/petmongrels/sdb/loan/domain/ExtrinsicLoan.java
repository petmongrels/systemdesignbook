package petmongrels.sdb.loan.domain;

import petmongrels.sdb.domain.Entity;

public class ExtrinsicLoan extends Entity {
    long productId;
    long customerId;
    String loanNumber;
    Fund fund;
    String purposeOfLoan;
    String notes;

    public String number() {
        return loanNumber;
    }

    public long productId() {
        return productId;
    }

    public ExtrinsicLoan productId(long productId) {
        this.productId = productId;
        return this;
    }

    public long customerId() {
        return customerId;
    }

    public ExtrinsicLoan customerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public Fund fund() {
        return fund;
    }

    public ExtrinsicLoan fund(Fund fund) {
        this.fund = fund;
        return this;
    }

    public String purposeOfLoan() {
        return purposeOfLoan;
    }

    public ExtrinsicLoan purposeOfLoan(String purposeOfLoan) {
        this.purposeOfLoan = purposeOfLoan;
        return this;
    }

    public String notes() {
        return notes;
    }

    public ExtrinsicLoan notes(String notes) {
        this.notes = notes;
        return this;
    }
}
