package org.owasp.esapi.core.authentication;

import java.io.Serializable;
import java.security.Principal;

/**
 * Authentication represents the Authentication Context for the current request. It is meant to serve as an abstraction
 * layer between the authentication mechanism and the application. If the request has not been authenticated yet, this
 * interface will represent the credentials for the {@link Authenticator} to use for authenticating identity. If the
 * request has already been authenticated, this interface will represent the authenticated context providing a bridge
 * between the authentication mechanism and the {@link User} representation for the application.
 *
 * @param <CT>  The type for the implmentation of {@link Credential}
 * @param <PT>  The type for the implemenation of the {@link Principal}
 */
public interface Authentication<CT extends Credential, PT extends Serializable> extends Principal {
    <T extends User> T getUser();
    CT getCredential();
    PT getPrincipal();
}
