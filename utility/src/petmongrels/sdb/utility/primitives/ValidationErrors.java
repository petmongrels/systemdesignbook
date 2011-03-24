package petmongrels.sdb.utility.primitives;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors {
    List<ValidationError> data = new ArrayList<ValidationError>();

    public void add(String code) {
        data.add(new ValidationError(code));
    }

    public void add(String code, String ... details) {
        data.add(new ValidationError(code, details));
    }

    public long size() {
        return data.size();
    }
}
