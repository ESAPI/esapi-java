package org.owasp.esapi.core.event;

import java.util.EventListener;

public interface SecurityEventListener extends EventListener {
    <T> void onSecurityEvent(SecurityEvent event, T eventContext);
}
