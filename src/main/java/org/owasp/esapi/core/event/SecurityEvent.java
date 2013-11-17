package org.owasp.esapi.core.event;

/**
 * SecurityEvent represents an the result of an action that generates a result that is contextual to application security.
 * An example of such an event could be a failed login attempt, a granted access control decision, or an attempt to bypass
 * a validation control by passing in input that uses multiple or mixed encoding.
 *
 * SecurityEvents are passed into the {@link org.owasp.esapi.core.logging.SecurityLogger} and can also be listened for by implementing the
 * {@link SecurityEventListener} interface. Listeners can subscribe to SecurityEvents using the
 *
 * @author Chris Schmidt (chris.schmidt@owasp.org) http://www.contrastsecurity.com
 */
public interface SecurityEvent {
    /**
     * Returns a label containing the type of event this represents.
     *
     * @return The type of SecurityEvent this implementation represents.
     */
    String getEventType();
}
