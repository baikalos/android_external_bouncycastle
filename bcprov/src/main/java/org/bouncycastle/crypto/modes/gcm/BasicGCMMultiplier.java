<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.crypto.modes.gcm;

public class BasicGCMMultiplier
    implements GCMMultiplier
{
    private long[] H;

    public void init(byte[] H)
    {
        this.H = GCMUtil.asLongs(H);
    }

    public void multiplyH(byte[] x)
    {
        GCMUtil.multiply(x, H);
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
