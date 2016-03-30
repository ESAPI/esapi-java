package org.owasp.esapi.core.validation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Test
public class ValidationErrorsTest {

    public static final String REGISTRATION = "registration";
    public static final String INVALID_EMAIL_ADDRESS_ERROR_MSG = "invalid email address";
    public static final String EMAIL = "email";
    private ValidationErrors validationErrors;

    @BeforeTest
    public void setup() {
        this.validationErrors = new ValidationErrors();
    }

    @Test
    public void testAddError() {
        ValidationError validationError = mock(ValidationError.class);
        when(validationError.getField()).thenReturn(EMAIL);
        when(validationError.getMessage()).thenReturn(INVALID_EMAIL_ADDRESS_ERROR_MSG);

        validationErrors.addError(REGISTRATION, validationError);
        List<ValidationError> errors = validationErrors.getErrors(REGISTRATION);

        assertThat(errors, notNullValue());
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0), is(validationError));
    }

    @Test
    public void testReturnedErrorsListIsUnmodifiable() {
        ValidationError validationError = mock(ValidationError.class);
        when(validationError.getField()).thenReturn(EMAIL);
        when(validationError.getMessage()).thenReturn(null);

        validationErrors.addError(REGISTRATION, validationError);
        List<ValidationError> errors = validationErrors.getErrors(REGISTRATION);

        try {
            errors.clear();
            fail("Should throw an exception as this is an unmodifiable list");
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testReturnedErrorsListIsEmptyForNonExistingContext() {
        List<ValidationError> errors = validationErrors.getErrors(REGISTRATION);

        assertThat(errors, notNullValue());
        assertThat(errors.size(), is(0));
    }

    @Test void testReturnNextError() {
        ValidationError inputError = mock(ValidationError.class);
        validationErrors.addError(REGISTRATION, inputError);
        validationErrors.nextError(REGISTRATION);

        ValidationError nextError = validationErrors.nextError(REGISTRATION);
        assertThat(nextError, nullValue());
    }

    @Test
    public void testClearingErrorList() {
        ValidationError validationError = mock(ValidationError.class);
        when(validationError.getField()).thenReturn(EMAIL);
        when(validationError.getMessage()).thenReturn(INVALID_EMAIL_ADDRESS_ERROR_MSG);

        validationErrors.addError(REGISTRATION, validationError);
        validationErrors.clear();

        assertThat(validationErrors.getErrors(REGISTRATION).size(), is(0));
    }
}
