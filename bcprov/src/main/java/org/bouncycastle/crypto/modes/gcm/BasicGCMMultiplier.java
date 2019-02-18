<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
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
        long[] t = GCMUtil.asLongs(x);
        GCMUtil.multiply(t, H);
        GCMUtil.asBytes(t, x);
    }
}
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
