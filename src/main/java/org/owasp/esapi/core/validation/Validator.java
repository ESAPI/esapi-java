package org.owasp.esapi.core.validation;

/**
 * The Validator interface defines a set of methods for canonicalizing and
 * validating untrusted input. In ESAPI 3.0 Validators can be used to validate
 * simple or complex data-types depending on the implementation.
 * <p/>
 * An example using the new ESAPI 3.0 annotations (JSR-303 Compliant) could
 * validate a user login form using the following code (Implementation Specific):
 * <pre>
 *     {@literal@}Validate
 *     public class UserLoginForm {
 *        {@literal@}LimitedCharSet(Chars.ALPHANUMONLY)
 *        {@literal@}Length(min=3, max=55)
 *        private String username;
 *
 *        {@literal@}Password(requiredChars={Chars.UPPER, Chars.LOWER, Chars.NUMBER, Chars.SPECIAL}, minLength=8)
 *        private String password;
 *
 *        // ....
 *     }
 *
 *     public class UserLoginController {
 *         private static final SecurityLogger SEC = SecurityLogger.get(UserLoginController.class);
 *
 *         public ModelAndView handleRequest(UserLoginForm form, HttpServletRequest request) {
 *            Model model = new Model(request);
 *
 *            try {
 *               ValidatorFactory.create(form).validate();
 *            } catch (ValidationException e) {
 *               model.setErrors(e.getErrorsAsMap());
 *               SEC.audit("Validation Failed", e);
 *            }
 *
 *            return new ModelAndView(model, "login");
 *         }
 *     }
 * </pre>
 * <p/>
 * Full JSR-303 (Java Bean Validation) compliance is available using the ESAPI 3.0 Validators and are compatible using
 * the reference Hibernate Validator.
 * <pre>
 *     public class UserLoginForm {
 *        {@literal@}LimitedCharSet(Chars.ALPHANUMONLY)
 *        {@literal@}Length(min=3, max=55)
 *        private String username;
 *
 *        {@literal@}Password(requiredChars={Chars.UPPER, Chars.LOWER, Chars.NUMBER, Chars.SPECIAL}, minLength=8)
 *        private String password;
 *
 *        // ....
 *     }
 *
 *     {@literal@}Controller
 *     public class UserLoginController {
 *         private static final SecurityLogger SEC = SecurityLogger.get(UserLoginController.class);
 *
 *         {@literal@}RequestMapping("/login", method=RequestMethod.POST)
 *         public ModelAndView handleRequest({@literal@}Valid UserLoginForm form, HttpServletRequest request) {
 *            // In Spring 3, using the {@literal@}Valid Annotation will automatically invoke the global validator
 *            // from Hibernate Validator to validate the form and set validation errors on the BindingResult
 *            // ...
 *         }
 *     }
 * </pre>
 * <p/>
 * Additionally, complex inline validations are now possible using the ESAPI 3.0 Validators.
 * <pre>
 *     ValidatorFactory.create("Email Address", {
 *         new AndValidationRule({
 *             new ValidEmailFormat(),
 *             new ValidDomain(ValidDomain.Type.EMAIL),
 *             new ValidMXRecord()
 *         })
 *     }).validate(email);
 * </pre>
 * <P/>
 * Implementations must adopt a "whitelist" approach to validation where a
 * specific pattern or character set is matched. "Blacklist" approaches that
 * attempt to identify the invalid or disallowed characters are much more likely
 * to allow a bypass with encoding or other tricks.
 *
 * @author Jeff Williams (jeff.williams .at. aspectsecurity.com) <a href="http://www.aspectsecurity.com">Aspect Security</a>
 * @author Chris Schmidt (chris.schmidt@owasp.org) <a href="http://www.contrastsecurity.com">Contrast Security</a>
 * @since June 1, 2007
 * @version 3.0
 */
public interface Validator {

    <T> void validate(T input) throws ValidationException;
}
