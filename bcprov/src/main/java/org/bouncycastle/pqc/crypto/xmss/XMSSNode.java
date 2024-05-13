<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;

/**
 * Binary tree node.
 */
public final class XMSSNode
    implements Serializable
{
    private static final long serialVersionUID = 1L;

    private final int height;
    private final byte[] value;

    protected XMSSNode(int height, byte[] value)
    {
        super();
        this.height = height;
        this.value = value;
    }

    public int getHeight()
    {
        return height;
    }

    public byte[] getValue()
    {
        return XMSSUtil.cloneArray(value);
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
