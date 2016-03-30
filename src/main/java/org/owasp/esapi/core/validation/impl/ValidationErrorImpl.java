package org.owasp.esapi.core.validation.impl;

import org.owasp.esapi.core.validation.ValidationError;

public final class ValidationErrorImpl implements ValidationError {
    protected static final String FIELD_NULL_EMPTY_ERROR = "Field cannot be null or empty";

    private String field;
    private String message;

    public ValidationErrorImpl(String field, String message) {
        if(null == field || field.isEmpty()) {
            throw new IllegalArgumentException(FIELD_NULL_EMPTY_ERROR);
        }
        this.field = field;
        this.message = message;
    }

    @Override
    public String getField() {
        return field;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationErrorImpl that = (ValidationErrorImpl) o;

        if (!field.equals(that.field)) return false;
        return message.equals(that.message);

    }

    @Override
    public int hashCode() {
        int result = field.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }
}
