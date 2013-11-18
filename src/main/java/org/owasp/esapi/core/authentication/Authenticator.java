package org.owasp.esapi.core.authentication;

import org.owasp.esapi.core.SecurityComponent;

import java.security.Principal;

/**
 * The Authenticator interface defines a set of methods for generating and
 * handling account credentials and session identifiers. The goal of this
 * interface is to encourage developers to protect credentials from disclosure
 * to the maximum extent possible.
 * <P>
 * The goal is to minimize the responsibility of the developer for
 * authentication.
 *
 * @author Jeff Williams (jeff.williams .at. aspectsecurity.com) <a href="http://www.aspectsecurity.com">Aspect Security</a>
 * @author Chris Schmidt (chris.schmidt@contrastsecurity.com)
 * @since June 1, 2007
 */
public interface Authenticator extends SecurityComponent {
    <Auth extends Authentication> Auth authenticate(Auth authentication) throws AuthenticationException;
}
