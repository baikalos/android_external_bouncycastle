<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

import java.io.IOException;

/**
 * Base interface for an object sending and receiving DTLS data.
 *
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public interface DatagramTransport
    extends TlsCloseable
{
    int getReceiveLimit()
        throws IOException;

    int getSendLimit()
        throws IOException;

    int receive(byte[] buf, int off, int len, int waitMillis)
        throws IOException;

    void send(byte[] buf, int off, int len)
        throws IOException;
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
