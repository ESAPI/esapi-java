package org.owasp.esapi.core.logging;

import org.owasp.esapi.core.event.SecurityEvent;

/**
 * This is a very basic generic implementation of the SecurityEvent interface that can be used for the {@link SecurityLogger}
 * to provide a very simple PASS/FAIL event type to the logging methods.
 * <p/>
 * The instances of this class are singleton in nature and can be referenced using the defined static constant singletons
 * <code>GenericSecurityLoggingEvent.PASS</code> and <code>GenericSecurityLoggingEvent.FAIL</code>.
 *
 * <pre>
 * securityLogger.audit(GenericSecurityLoggingEvent.PASS, "User {0} invoked administrative option {1}", user.getUsername(), functionIvoked);
 * </pre>
 *
 * @author Chris Schmidt (chris.schmidt@owasp.org) http://www.ContrastSecurity.com
 */
@SuppressWarnings("UnusedDeclaration")
public class GenericSecurityLoggingEvent implements SecurityEvent {

    private static final String LBL_PASS = "PASS";
    private static final String LBL_FAIL = "FAIL";


    public static final SecurityEvent PASS = new GenericSecurityLoggingEvent(LBL_PASS);
    public static final SecurityEvent FAIL = new GenericSecurityLoggingEvent(LBL_FAIL);

    private String label;

    private GenericSecurityLoggingEvent(String label) {
        this.label = label;
    }

    /**
     * Returns a label containing the type of event this represents.
     *
     * @return The type of SecurityEvent this implementation represents.
     */
    @Override
    public String getEventType() {
        return label;
    }
}
