package petmongrels.sdb.loan.domain;

public enum LoanAccountStatus {
    PENDING_APPROVAL,
    DISBURSED,
    ACTIVE,
    CANCELLED,
    ACTIVE_IN_GOOD_STANDING,
    CLOSED_WRITTEN_OFF,
    CLOSED_RESCHEDULED,
    IN_BAD_STANDING
}