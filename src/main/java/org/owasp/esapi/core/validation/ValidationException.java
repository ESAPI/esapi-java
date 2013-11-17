package org.owasp.esapi.core.validation;

import org.owasp.esapi.core.EnterpriseSecurityException;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
public class ValidationException extends EnterpriseSecurityException {
    private List<ValidationError> errors;

    public ValidationException(String userMessage, String logMessage, ValidationError... errors) {
        super(userMessage,logMessage);
        this.errors = Arrays.asList(errors);
    }

    public ValidationException(String userMessage, String logMessage, List<ValidationError> errors) {
        super(userMessage, logMessage);
        this.errors = errors;
    }

    public ValidationException(String userMessage, String logMessage, Throwable cause, List<ValidationError> errors) {
        super(userMessage, logMessage, cause);
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
