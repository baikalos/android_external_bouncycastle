<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;

import org.bouncycastle.crypto.prng.RandomGenerator;

/**
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public interface TlsContext
{
    RandomGenerator getNonceRandomGenerator();

    SecureRandom getSecureRandom();

    SecurityParameters getSecurityParameters();

    boolean isServer();

    ProtocolVersion getClientVersion();

    ProtocolVersion getServerVersion();

    /**
     * Used to get the resumable session, if any, used by this connection. Only available after the
     * handshake has successfully completed.
     * 
     * @return A {@link TlsSession} representing the resumable session used by this connection, or
     *         null if no resumable session available.
     * @see TlsPeer#notifyHandshakeComplete()
     */
    TlsSession getResumableSession();

    Object getUserObject();

    void setUserObject(Object userObject);

    /**
     * Export keying material according to RFC 5705: "Keying Material Exporters for TLS".
     *
     * @param asciiLabel    indicates which application will use the exported keys.
     * @param context_value allows the application using the exporter to mix its own data with the TLS PRF for
     *                      the exporter output.
     * @param length        the number of bytes to generate
     * @return a pseudorandom bit string of 'length' bytes generated from the master_secret.
     */
    byte[] exportKeyingMaterial(String asciiLabel, byte[] context_value, int length);
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
