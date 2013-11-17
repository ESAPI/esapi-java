package org.owasp.esapi.core;

@SuppressWarnings("UnusedDeclaration")
public class EnterpriseSecurityRuntimeException extends RuntimeException {

    protected static final long serialVersionUID = 1L;

    /**
     *
     */
    protected String logMessage = null;

    /**
     * Instantiates a new security exception.
     */
    private EnterpriseSecurityRuntimeException() {
        // hidden
    }

    /**
     * Creates a new instance of EnterpriseSecurityException. This exception is automatically logged, so that simply by
     * using this API, applications will generate an extensive security log. In addition, this exception is
     * automatically registered with the IntrusionDetector, so that quotas can be checked.
     *
     * It should be noted that messages that are intended to be displayed to the user should be safe for display. In
     * other words, don't pass in unsanitized data here. Also could hold true for the logging message depending on the
     * context of the exception.
     *
     * @param userMessage
     * 			  the message displayed to the user
     * @param logMessage
     * 			  the message logged
     */
    public EnterpriseSecurityRuntimeException(String userMessage, String logMessage) {
        super(userMessage);
        this.logMessage = logMessage;
    }

    /**
     * Creates a new instance of EnterpriseSecurityException that includes a root cause Throwable.
     *
     * It should be noted that messages that are intended to be displayed to the user should be safe for display. In
     * other words, don't pass in unsanitized data here. Also could hold true for the logging message depending on the
     * context of the exception.
     *
     * @param userMessage
     * 			  the message displayed to the user
     * @param logMessage
     * 			  the message logged
     * @param cause the cause
     */
    public EnterpriseSecurityRuntimeException(String userMessage, String logMessage, Throwable cause) {
        super(userMessage, cause);
        this.logMessage = logMessage;
    }

    /**
     * Returns message meant for display to users
     *
     * Note that if you are unsure of what set this message, it would probably
     * be a good idea to encode this message before displaying it to the end user.
     *
     * @return a String containing a message that is safe to display to users
     */
    public String getUserMessage() {
        return getMessage();
    }

    /**
     * Returns a message that is safe to display in logs, but may contain
     * sensitive information and therefore probably should not be displayed to
     * users.
     *
     * @return a String containing a message that is safe to display in logs,
     * but probably not to users as it may contain sensitive information.
     */
    public String getLogMessage() {
        return logMessage;
    }
}
