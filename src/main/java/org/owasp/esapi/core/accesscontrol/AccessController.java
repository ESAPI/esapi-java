package org.owasp.esapi.core.accesscontrol;

/**
 * The AccessController interface defines a set of methods that can be used in a wide variety of applications to
 * enforce access control. In most applications, access control must be performed in multiple different locations across
 * the various application layers.
 * <P>
 * The implementation of this interface will need to access the current User object (from Authenticator.getCurrentUser())
 * to determine roles or permissions. In addition, the implementation will also need information about the resources that
 * are being accessed. Using the user information and the resource information, the implementation should return an
 * access control decision.
 * <P>
 * The point of the ESAPI access control interface is to centralize access control logic behind easy to use calls like
 * assertAuthorized() so that access control is easy to use and easy to verify. Here is an example of a very
 * straightforward to implement, understand, and verify ESAPI access control check:
 *
 * <pre>
 * try {
 *     ESAPI.accessController().assertAuthorized("businessFunction", runtimeData);
 *     // execute BUSINESS_FUNCTION
 * } catch (AccessControlException ace) {
 * ... attack in progress
 * }
 * </pre>
 *
 * Note that in the user interface layer, access control checks can be used to control whether particular controls are
 * rendered or not. These checks are supposed to fail when an unauthorized user is logged in, and do not represent
 * attacks. Remember that regardless of how the user interface appears, an attacker can attempt to invoke any business
 * function or access any data in your application. Therefore, access control checks in the user interface should be
 * repeated in both the business logic and data layers.
 *
 * <pre>
 * &lt;% if ( ESAPI.accessController().isAuthorized( "businessFunction", runtimeData ) ) { %&gt;
 * &lt;a href=&quot;/doAdminFunction&quot;&gt;ADMIN&lt;/a&gt;
 * &lt;% } else { %&gt;
 * &lt;a href=&quot;/doNormalFunction&quot;&gt;NORMAL&lt;/a&gt;
 * &lt;% } %&gt;
 * </pre>
 *
 * @author Mike H. Fauzy (mike.fauzy@aspectsecurity.com) ESAPI v1.6-
 * @author Jeff Williams (jeff.williams@aspectsecurity.com) ESAPI v0-1.5
 * @author Chris Schmidt (chris.schmidt@contrastsecurity.com) ESAPI v3.0
 */
public interface AccessController {
    /**
     * Developers should call isAuthorized to control execution flow. For
     * example, if you want to decide whether to display a UI widget in the
     * browser using the same logic that you will use to enforce permissions
     * on the server, then isAuthorized is the method that you want to use.
     *
     * Typically, assertAuthorized should be used to enforce permissions on the
     * server.
     *
     * @param key
     * @param runtimeParameter
     * @return
     */
    public boolean isAuthorized(Object key, Object runtimeParameter);

    /**
     * Developers should call {@code assertAuthorized} to enforce privileged access to
     * the system. It should be used to answer the question: "Should execution
     * continue." Ideally, the call to <code>assertAuthorized</code> should
     * be integrated into the application framework so that it is called
     * automatically.
     *
     * @param key
     * @param runtimeParameter
     */
    public void assertAuthorized(Object key, Object runtimeParameter) throws AccessControlException;

}
