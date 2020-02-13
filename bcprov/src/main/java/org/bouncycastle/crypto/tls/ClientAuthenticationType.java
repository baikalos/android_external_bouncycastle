<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

/**
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public class ClientAuthenticationType
{
    /*
     * RFC 5077 4
     */
    public static final short anonymous = 0;
    public static final short certificate_based = 1;
    public static final short psk = 2;
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
