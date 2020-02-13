<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

/**
 * RFC 5246 7.2
 *
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public class AlertLevel
{
    public static final short warning = 1;
    public static final short fatal = 2;

    public static String getName(short alertDescription)
    {
        switch (alertDescription)
        {
        case warning:
            return "warning";
        case fatal:
            return "fatal";
        default:
            return "UNKNOWN";
        }
    }

    public static String getText(short alertDescription)
    {
        return getName(alertDescription) + "(" + alertDescription + ")";
    }
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
