<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

/**
 * RFC 2246
 * <p>
 * Note that the values here are implementation-specific and arbitrary. It is recommended not to
 * depend on the particular values (e.g. serialization).
 *
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public class MACAlgorithm
{
    public static final int _null = 0;
    public static final int md5 = 1;
    public static final int sha = 2;

    /*
     * RFC 5246
     */
    public static final int hmac_md5 = md5;
    public static final int hmac_sha1 = sha;
    public static final int hmac_sha256 = 3;
    public static final int hmac_sha384 = 4;
    public static final int hmac_sha512 = 5;
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
