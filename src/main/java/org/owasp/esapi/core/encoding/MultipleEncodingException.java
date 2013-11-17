package org.owasp.esapi.core.encoding;

@SuppressWarnings("UnusedDeclaration")
public class MultipleEncodingException extends EncodingException {
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
    public MultipleEncodingException(String userMessage, String logMessage) {
        super(userMessage, logMessage);
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
    public MultipleEncodingException(String userMessage, String logMessage, Throwable cause) {
        super(userMessage, logMessage, cause);
    }
}
