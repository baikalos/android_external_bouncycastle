package org.bouncycastle.crypto.digests;

<<<<<<< HEAD
=======
import org.bouncycastle.util.Arrays;

>>>>>>> aosp/upstream-master
public class XofUtils
{
    public static byte[] leftEncode(long strLen)
    {
<<<<<<< HEAD
    	byte n = 1;

        long v = strLen;
    	while ((v >>= 8) != 0)
        {
    		n++;
    	}

        byte[] b = new byte[n + 1];

    	b[0] = n;

    	for (int i = 1; i <= n; i++)
    	{
    		b[i] = (byte)(strLen >> (8 * (n - i)));
    	}

    	return b;
=======
        byte n = 1;

        long v = strLen;
        while ((v >>= 8) != 0)
        {
            n++;
        }

        byte[] b = new byte[n + 1];

        b[0] = n;

        for (int i = 1; i <= n; i++)
        {
            b[i] = (byte)(strLen >> (8 * (n - i)));
        }

        return b;
>>>>>>> aosp/upstream-master
    }

    public static byte[] rightEncode(long strLen)
    {
        byte n = 1;

        long v = strLen;
        while ((v >>= 8) != 0)
        {
            n++;
        }

        byte[] b = new byte[n + 1];

        b[n] = n;

        for (int i = 0; i < n; i++)
        {
            b[i] = (byte)(strLen >> (8 * (n - i - 1)));
        }

        return b;
    }
<<<<<<< HEAD
=======

    static byte[] encode(byte X)
    {
        return Arrays.concatenate(XofUtils.leftEncode(8), new byte[] { X });
    }

    static byte[] encode(byte[] in, int inOff, int len)
    {
        if (in.length == len)
        {
            return Arrays.concatenate(XofUtils.leftEncode(len * 8), in);
        }
        return Arrays.concatenate(XofUtils.leftEncode(len * 8), Arrays.copyOfRange(in, inOff, inOff + len));
    }
>>>>>>> aosp/upstream-master
}
