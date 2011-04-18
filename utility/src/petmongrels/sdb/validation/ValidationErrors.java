package petmongrels.sdb.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationErrors {
    List<ValidationError> data = new ArrayList<ValidationError>();

    public ValidationErrors add(String code) {
        data.add(new ValidationError(code));
        return this;
    }

    public ValidationErrors add(String code, String description) {
        data.add(new ValidationError(code, description));
        return this;
    }

    public long size() {
        return data.size();
    }

    public void append(ValidationErrors validationErrors) {
        data.addAll(validationErrors.data);
    }

    public boolean exist() {
        return size() > 0;
    }

    public ValidationErrors keep(String[] codes) {
        List<String> codeList = Arrays.asList(codes);
        int dataSize = data.size();
        for (int i = 0, j = 0; i < dataSize; i++, j++) {
            ValidationError validationError = data.get(j);
            if (!codeList.contains(validationError.getCode())) {
                data.remove(validationError);
                j--;
            }
        }
        return this;
    }
}
