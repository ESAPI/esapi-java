package org.owasp.esapi.core.logging;

public interface SecurityLoggerFactory<K> {

    <T extends SecurityLogger, K> T getLogger(K loggerKey);
}
