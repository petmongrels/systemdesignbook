package petmongrels.sdb.application.request;

import petmongrels.sdb.validation.ValidationErrors;

public class ServiceResponse {
    public ValidationErrors Errors;

    public ServiceResponse(ValidationErrors errors) {
        Errors = errors;
    }

    protected ServiceResponse() {
    }
}
