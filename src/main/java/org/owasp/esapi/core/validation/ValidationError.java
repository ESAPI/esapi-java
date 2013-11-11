package org.owasp.esapi.core.validation;

public interface ValidationError {
    String getField();
    String getMessage();
}
