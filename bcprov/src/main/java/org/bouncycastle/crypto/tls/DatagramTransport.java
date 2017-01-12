<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
=======
package org.bouncycastle.crypto.tls;

import java.io.IOException;

/**
 * Base interface for an object sending and receiving DTLS data.
 */
public interface DatagramTransport
{
    int getReceiveLimit()
        throws IOException;

    int getSendLimit()
        throws IOException;

    int receive(byte[] buf, int off, int len, int waitMillis)
        throws IOException;

    void send(byte[] buf, int off, int len)
        throws IOException;

    void close()
        throws IOException;
}
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
