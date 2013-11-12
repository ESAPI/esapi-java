package org.owasp.esapi.core.validation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("UnusedDeclaration")
public class ValidationErrors implements Serializable {
    private static final long serialVersionUID = 20131112L;

    private Map<String,Stack<ValidationError>> errors;

    public ValidationErrors() {
        this.errors = new ConcurrentHashMap<String, Stack<ValidationError>>();
    }

    public void addError(String context, ValidationError error) {
        Stack<ValidationError> errorsForContext = errors.get(context);
        if (errorsForContext == null) {
            errorsForContext = new Stack<ValidationError>();
            errors.put(context, errorsForContext);
        }

        errorsForContext.add(error);
    }

    public ValidationError nextError(String context) {
        Stack<ValidationError> errorsForContext = errors.get(context);
        if (errorsForContext == null) {
            return null;
        }

        return errorsForContext.pop();
    }

    public List<ValidationError> getErrors(String context) {
        return errors.get(context);
    }

    public void clear() {
        this.errors = new ConcurrentHashMap<String, Stack<ValidationError>>();
    }
}
