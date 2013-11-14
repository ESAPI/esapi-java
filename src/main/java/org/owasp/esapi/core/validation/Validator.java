package org.owasp.esapi.core.validation;

/**
 * The Validator interface defines a set of methods for canonicalizing and validating untrusted input. Validators can be
 * used to validate simple or complex data-types depending on the implementation.
 * <p/>
 * Implementations must adopt a "whitelist" approach to validation where a specific pattern or character set is
 * matched. "Blacklist" approaches that attempt to identify the invalid or disallowed characters are much more likely
 * to allow a bypass with encoding or other tricks.
 *
 * @author Jeff Williams (jeff.williams .at. aspectsecurity.com) <a href="http://www.aspectsecurity.com">Aspect Security</a>
 * @author Chris Schmidt (chris.schmidt@owasp.org) <a href="http://www.contrastsecurity.com">Contrast Security</a>
 * @since June 1, 2007
 * @version 3.0
 */
@SuppressWarnings("UnusedDeclaration")
public interface Validator {
    /**
     * Validates the given input and throws a {@link ValidationException} if validation fails.
     *
     * @param input The input to be validated.
     * @param <T> Data-Type inferred by the input argument.
     * @throws ValidationException When validation fails.
     */
    <T> void validate(T input) throws ValidationException;

    /**
     * Validates the given input and adds failures to the supplied {@link ValidationErrors} object.
     *
     * @param input The input to be validated
     * @param errors The {@link ValidationErrors} instance to append errors to.
     * @param <T> Data-Type inferred by the input argument.
     */
    <T> void validate(T input, ValidationErrors errors);

    /**
     * Returns whether the supplied object is supported by this Validator instance.
     *
     * @param input The object that is to be validated.
     * @return True if this validator supports the supplied data, false otherwise.
     */
    boolean supports(Object input);

    /**
     * Canonicalizes the given input to it's simplest form. Implementors should ensure that canonicalize throws
     * a {@link ValidationException} if the input contains multiple or mixed encodings in most cases, special cases
     * may allow these specific situations.
     *
     * Validation should invoke this method prior to validating data.
     *
     * @param input The input to be canonicalized
     * @param <T> Data-Type inferred by the input argument
     * @return The supplied input reduced to it's simplest form.
     */
    <T> T canonicalize(T input) throws ValidationException;
}
