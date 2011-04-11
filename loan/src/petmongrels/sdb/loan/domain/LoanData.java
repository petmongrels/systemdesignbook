package petmongrels.sdb.loan.domain;

import petmongrels.sdb.domain.Entity;

public class LoanData extends Entity {
    private long productId;
    private long customerId;
    private String loanNumber;

    public String getNumber() {
        return loanNumber;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
