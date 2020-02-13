<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.pqc.crypto.xmss;

/**
 * Interface for XMSS objects that need to be storeable as a byte array.
 *
 * @deprecated use Encodable
 */
public interface XMSSStoreableObjectInterface
{

    /**
     * Create byte representation of object.
     *
     * @return Byte representation of object.
     */
    public byte[] toByteArray();
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
