package petmongrels.sdb.validation;

public class ValidationError {
    int index;
    String code;
    String detail;

    public static final int NoIndex = -1;

    public ValidationError(String code) {
        this(code, null);
    }

    public ValidationError(String code, String detail) {
        this(NoIndex, code, detail);
    }

    public ValidationError(int index, String code, String detail) {
        this.code = code;
        this.detail = detail;
        this.index = index;
    }

    public String getCode() {
        return code;
    }
}
