package org.owasp.esapi.core;

/**
 * This is the very basic interface that all Security Control implementations should implement. It is expected that each
 * control/component will have a UUID associated with it so that locater services can locate the implementations based on
 * some registry and to allow multiple instances of single components to exist within an application.
 *
 * @author Chris Schmidt (chris.schmidt@owasp.org) http://www.ContrastSecurity.com
 */
public interface SecurityComponent {
    /**
     * Returns the Unique Identifier for this component/control instance.
     * @return Unique Identifier for this component/control instance
     */
    Object getComponentID();
}
