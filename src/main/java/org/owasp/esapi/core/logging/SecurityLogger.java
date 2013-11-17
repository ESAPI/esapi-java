package org.owasp.esapi.core.logging;

import org.owasp.esapi.core.SecurityComponent;
import org.owasp.esapi.core.event.SecurityEvent;

/**
 * The SecurityLogger interface replaces the Logger interface from ESAPI 2.x. The SecurityLogger is intended to be used
 * to log security specific events, and is generally intended to be logged into a dedicated repository intended for only
 * security events.
 *
 * There are several different levels that can be logged into, implementors are responsible for mapping the SecurityLogger
 * methdos to their Logging equivelant in an adaptor class.
 *
 * Each method expects a {@link org.owasp.esapi.core.event.SecurityEvent} to be supplied, this event will contain contextual information about the
 * logging event in addition to the event description which can be logged allowing filtering based off of Security Event
 * when parsing or reading Security logs.
 */
public interface SecurityLogger extends SecurityComponent {
    <T extends SecurityEvent> void audit(T event, String message, Object... parms);
    <T extends SecurityEvent> void audit(T event, Throwable t, String message, Object... parms);

    <T extends SecurityEvent> void always(T event, String message, Object... parms);
    <T extends SecurityEvent> void always(T event, Throwable t, String message, Object... parms);

    <T extends SecurityEvent> void debug(T event, String message, Object... parms);
    <T extends SecurityEvent> void debug(T event, Throwable t, String message, Object... parms);

    <T extends SecurityEvent> void info(T event, String message, Object... parms);
    <T extends SecurityEvent> void info(T event, Throwable t, String message, Object... parms);

    <T extends SecurityEvent> void warn(T event, String message, Object... parms);
    <T extends SecurityEvent> void warn(T event, Throwable t, String message, Object... parms);

    <T extends SecurityEvent> void error(T event, String message, Object... parms);
    <T extends SecurityEvent> void error(T event, Throwable t, String message, Object... parms);
}
