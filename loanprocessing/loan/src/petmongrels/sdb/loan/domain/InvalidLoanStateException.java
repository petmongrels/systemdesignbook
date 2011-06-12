package petmongrels.sdb.loan.domain;

public class InvalidLoanStateException extends RuntimeException {
    public InvalidLoanStateException(String s) {
        super(s);
    }
}
