<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

/**
 * RFC 5246
 * <p>
 * Note that the values here are implementation-specific and arbitrary. It is recommended not to
 * depend on the particular values (e.g. serialization).
 *
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public class PRFAlgorithm
{
    /*
     * Placeholder to refer to the legacy TLS algorithm
     */
    public static final int tls_prf_legacy = 0;

    public static final int tls_prf_sha256 = 1;

    /*
     * Implied by RFC 5288
     */
    public static final int tls_prf_sha384 = 2;
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
