package org.owasp.esapi.core.accesscontrol;

import java.io.Serializable;

/**
 *
 */
public interface ManagedResource<T extends Serializable> {
    T getResourceIdentifier();
}
