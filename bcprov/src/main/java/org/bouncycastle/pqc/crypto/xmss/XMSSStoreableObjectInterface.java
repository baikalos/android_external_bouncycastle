<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
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
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
