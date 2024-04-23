/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.org.bouncycastle.crypto.modes.gcm;

<<<<<<< HEAD:repackaged/bcprov/src/main/java/com/android/org/bouncycastle/crypto/modes/gcm/Tables8kGCMMultiplier.java
import com.android.org.bouncycastle.util.Arrays;
import com.android.org.bouncycastle.util.Pack;
=======
import org.bouncycastle.util.Pack;
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/crypto/modes/gcm/Tables64kGCMMultiplier.java

/**
 * @hide This class is not part of the Android public SDK API
 */
public class Tables8kGCMMultiplier
    implements GCMMultiplier
{
    private byte[] H;
    private long[][][] T;

    public void init(byte[] H)
    {
        if (T == null)
        {
            T = new long[32][16][2];
        }
        else if (0 != GCMUtil.areEqual(this.H, H))
        {
            return;
        }

        this.H = new byte[GCMUtil.SIZE_BYTES];
        GCMUtil.copy(H, this.H);

        for (int i = 0; i < 32; ++i)
        {
            long[][] t = T[i];

            // t[0] = 0

            if (i == 0)
            {
                // t[1] = H.p^3
                GCMUtil.asLongs(this.H, t[1]);
                GCMUtil.multiplyP3(t[1], t[1]);
            }
            else
            {
                // t[1] = T[i-1][1].p^4
                GCMUtil.multiplyP4(T[i - 1][1], t[1]);
            }

            for (int n = 2; n < 16; n += 2)
            {
                // t[2.n] = t[n].p^-1
                GCMUtil.divideP(t[n >> 1], t[n]);

                // t[2.n + 1] = t[2.n] + t[1]
                GCMUtil.xor(t[n], t[1], t[n + 1]);
            }
        }

    }

    public void multiplyH(byte[] x)
    {
//        long[] z = new long[2];
//        for (int i = 15; i >= 0; --i)
//        {
//            GCMUtil.xor(z, T[i + i + 1][(x[i] & 0x0F)]);
//            GCMUtil.xor(z, T[i + i    ][(x[i] & 0xF0) >>> 4]);
//        }
//        Pack.longToBigEndian(z, x, 0);

<<<<<<< HEAD:repackaged/bcprov/src/main/java/com/android/org/bouncycastle/crypto/modes/gcm/Tables8kGCMMultiplier.java
        long z0 = 0, z1 = 0;

        for (int i = 15; i >= 0; --i)
        {
            long[] u = T[i + i + 1][(x[i] & 0x0F)];
            long[] v = T[i + i    ][(x[i] & 0xF0) >>> 4];

            z0 ^= u[0] ^ v[0];
            z1 ^= u[1] ^ v[1];
        }
=======
        long[] t00 = T[ 0][x[ 0] & 0xFF];
        long[] t01 = T[ 1][x[ 1] & 0xFF];
        long[] t02 = T[ 2][x[ 2] & 0xFF];
        long[] t03 = T[ 3][x[ 3] & 0xFF];
        long[] t04 = T[ 4][x[ 4] & 0xFF];
        long[] t05 = T[ 5][x[ 5] & 0xFF];
        long[] t06 = T[ 6][x[ 6] & 0xFF];
        long[] t07 = T[ 7][x[ 7] & 0xFF];
        long[] t08 = T[ 8][x[ 8] & 0xFF];
        long[] t09 = T[ 9][x[ 9] & 0xFF];
        long[] t10 = T[10][x[10] & 0xFF];
        long[] t11 = T[11][x[11] & 0xFF];
        long[] t12 = T[12][x[12] & 0xFF];
        long[] t13 = T[13][x[13] & 0xFF];
        long[] t14 = T[14][x[14] & 0xFF];
        long[] t15 = T[15][x[15] & 0xFF];

        long z0 = t00[0] ^ t01[0] ^ t02[0] ^ t03[0] ^ t04[0] ^ t05[0] ^ t06[0] ^ t07[0]
                ^ t08[0] ^ t09[0] ^ t10[0] ^ t11[0] ^ t12[0] ^ t13[0] ^ t14[0] ^ t15[0];
        long z1 = t00[1] ^ t01[1] ^ t02[1] ^ t03[1] ^ t04[1] ^ t05[1] ^ t06[1] ^ t07[1]
                ^ t08[1] ^ t09[1] ^ t10[1] ^ t11[1] ^ t12[1] ^ t13[1] ^ t14[1] ^ t15[1];
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/crypto/modes/gcm/Tables64kGCMMultiplier.java

        Pack.longToBigEndian(z0, x, 0);
        Pack.longToBigEndian(z1, x, 8);
   }
}
