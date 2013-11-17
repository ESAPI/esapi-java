package org.owasp.esapi.core.configuration;

import org.owasp.esapi.core.SecurityComponent;

import java.util.UUID;

public interface ComponentConfigurationManager extends SecurityComponent {
    /**
     * Looks up the configuration for a component by it's UUID.
     *
     * @param componentID
     * @param <Configuration>
     * @return
     */
    <Configuration> Configuration getComponentConfiguration(UUID componentID);

    /**
     * Looks up the configuration for a specific instance of a component by it's UUID and a supplied instance qualifier.
     * @param component
     * @param instanceQualifier
     * @param <Configuration>
     * @param <InstanceQualifier>
     * @return
     */
    <Configuration,InstanceQualifier> Configuration getInstanceConfiguration(UUID component, InstanceQualifier instanceQualifier);
}
