package petmongrels.sdb.utility.primitives;

public class ValidationError {
    String code;
    String[] details;

    public ValidationError(String code) {
        this.code = code;
    }

    public ValidationError(String code, String[] details) {
        this.code = code;
        this.details = details;
    }
}
