package org.owasp.esapi.core.accesscontrol;

/**
 * The AccessControlContext is a marker interface that is passed in to {@link AccessController#isAuthorized(ManagedResource, AccessControlContext)}
 * and {@link AccessController#assertAuthorized(ManagedResource, AccessControlContext)} methods to provide the context of
 * an access control check to the {@link AccessController} implementation. Adding context to an access control request
 * allows the implementation to perform more complex access control decisions.
 * <p/>
 * For data level access control this can be something as simple as a object containing the requested function on the
 * provided data such as:
 * <pre>
 * public class ManagedDataOperation implements AccessControlContext {
 *    public static enum Permission { CREATE, READ, UPDATE, DELETE }
 *
 *    private Permission permission;
 *
 *    public ManagedDataOperation(Permission permission) {
 *        this.permission = permission;
 *    }
 *
 *    public Permission getPermission() {
 *        return this.permission;
 *    }
 * }
 * </pre>
 * For more complex access control decisions this could contain any number of variables that are used to make an
 * access control decision.
 */
public interface AccessControlContext {
}
