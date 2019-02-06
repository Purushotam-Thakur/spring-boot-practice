package com.in28minutes.rest.webservices.restfullwebservices.exception;

import java.util.List;

public class ApiErrorsView {
    private List<ApiFieldError> violations;

    public ApiErrorsView(List<ApiFieldError> fieldErrors) {
        this.violations = fieldErrors;
    }

    public List<ApiFieldError> getViolations() {
        return violations;
    }
}
