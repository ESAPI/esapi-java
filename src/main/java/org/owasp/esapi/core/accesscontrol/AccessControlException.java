package org.owasp.esapi.core.accesscontrol;

import org.owasp.esapi.core.EnterpriseSecurityException;

import java.io.Serializable;

@SuppressWarnings("UnusedDeclaration")
public class AccessControlException extends EnterpriseSecurityException {
    private Serializable resourceReference;

    /**
     * Creates a new instance of EnterpriseSecurityException. This exception is automatically logged, so that simply by
     * using this API, applications will generate an extensive security log. In addition, this exception is
     * automatically registered with the IntrusionDetector, so that quotas can be checked.
     * <p/>
     * It should be noted that messages that are intended to be displayed to the user should be safe for display. In
     * other words, don't pass in unsanitized data here. Also could hold true for the logging message depending on the
     * context of the exception.
     *
     * @param userMessage the message displayed to the user
     * @param logMessage  the message logged
     */
    public AccessControlException(String userMessage, String logMessage, Serializable resourceReference) {
        super(userMessage, logMessage);
        this.resourceReference = resourceReference;
    }

    /**
     * Creates a new instance of EnterpriseSecurityException that includes a root cause Throwable.
     * <p/>
     * It should be noted that messages that are intended to be displayed to the user should be safe for display. In
     * other words, don't pass in unsanitized data here. Also could hold true for the logging message depending on the
     * context of the exception.
     *
     * @param userMessage the message displayed to the user
     * @param logMessage  the message logged
     * @param cause       the cause
     */
    public AccessControlException(String userMessage, String logMessage, Throwable cause, Serializable resourceReference) {
        super(userMessage, logMessage, cause);
        this.resourceReference = resourceReference;
    }

    public Serializable getResourceReference() {
        return resourceReference;
    }
}
