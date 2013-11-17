package org.owasp.esapi.core.policy;

public interface EnterpriseSecurityPolicy {
    /* TODO: [CS] Not quite sure what to do here yet - we need a design that allows an open-ended but centralized policy
             management engine. Should component configurations be expected to provide the policy template to the
             EnterpriseSecurityPolicy implementation at time of discovery. How does this lend to a front end tool that
             allows centralized management of the entire security policy for an organization.

             This requires a little more thought from our end before this is ready to use.
     */
}
