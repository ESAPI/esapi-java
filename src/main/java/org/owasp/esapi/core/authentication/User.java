package org.owasp.esapi.core.authentication;

import java.io.Serializable;
import java.util.Date;

public interface User extends Serializable {
    boolean isEnabled();
    Date getExpiration();

    // Failed Login Information
    int getFailedLoginCount();
    Date getLastFailedLoginDate();
    String getLastFailedLoginHost();

    // Successful Login Information
    Date getLastLoginDate();
    String getLastLoginHost();
}
