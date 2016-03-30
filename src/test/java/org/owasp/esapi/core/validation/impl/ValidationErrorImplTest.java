package org.owasp.esapi.core.validation.impl;

import org.owasp.esapi.core.validation.ValidationError;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@Test
public class ValidationErrorImplTest {

    public static final String FIELD_EMAIL = "email";
    public static final String MSG_EMAIL = "Invalid email address";

    @Test
    public void testCreateValidationErrorSuccessfully() {
        ValidationError validationError = new ValidationErrorImpl(FIELD_EMAIL, MSG_EMAIL);
        assertThat(validationError, notNullValue());
        assertThat(validationError.getField(), equalTo(FIELD_EMAIL));
        assertThat(validationError.getMessage(), equalTo(MSG_EMAIL));
    }

    @Test
    public void testThrowsErrorWhenFieldIsEmpty() {
        try {
            new ValidationErrorImpl(null, MSG_EMAIL);
            fail("Should throw exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), equalTo(ValidationErrorImpl.FIELD_NULL_EMPTY_ERROR));
        }
    }

    @Test
    public void testEquality() {
        ValidationError validationError = new ValidationErrorImpl(FIELD_EMAIL, MSG_EMAIL);
        ValidationError validationError2 = new ValidationErrorImpl(FIELD_EMAIL, MSG_EMAIL);
        assertThat(validationError, equalTo(validationError2));
        assertThat(validationError.hashCode(), equalTo(validationError2.hashCode()));
    }
}
