package org.owasp.esapi.core.validation;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        try {
            return errorsForContext.pop();
        } catch (EmptyStackException ese) {
            return null;
        }
    }

    public List<ValidationError> getErrors(String context) {
        List<ValidationError> errorListToReturn = new ArrayList<ValidationError>();

        List<ValidationError> errorListForContext = errors.get(context);

        if(null != errorListForContext) {
            errorListToReturn.addAll(errorListForContext);
        }

        return Collections.unmodifiableList(errorListToReturn);
    }

    public void clear() {
        this.errors = new ConcurrentHashMap<String, Stack<ValidationError>>();
    }
}
