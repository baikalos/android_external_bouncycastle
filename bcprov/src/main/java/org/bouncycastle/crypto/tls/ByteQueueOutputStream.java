<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public class ByteQueueOutputStream
    extends OutputStream
{
    private ByteQueue buffer;

    public ByteQueueOutputStream()
    {
        buffer = new ByteQueue();
    }

    public ByteQueue getBuffer()
    {
        return buffer;
    }

    public void write(int b) throws IOException
    {
        buffer.addData(new byte[]{ (byte)b }, 0, 1);
    }

    public void write(byte[] b, int off, int len) throws IOException
    {
        buffer.addData(b, off, len);
    }
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
