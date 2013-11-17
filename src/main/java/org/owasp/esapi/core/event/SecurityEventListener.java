package org.owasp.esapi.core.event;

import org.owasp.esapi.core.SecurityComponent;

import java.util.EventListener;

public interface SecurityEventListener extends EventListener, SecurityComponent {
    <T> void onSecurityEvent(SecurityEvent event, T eventContext);
}
