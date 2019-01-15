/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.org.bouncycastle.crypto.digests;

import java.io.ByteArrayOutputStream;

import com.android.org.bouncycastle.crypto.Digest;


/**
 * @hide This class is not part of the Android public SDK API
 */
public class NullDigest
    implements Digest
{
    private ByteArrayOutputStream bOut = new ByteArrayOutputStream();

    public String getAlgorithmName()
    {
        return "NULL";
    }

    public int getDigestSize()
    {
        return bOut.size();
    }

    public void update(byte in)
    {
        bOut.write(in);
    }

    public void update(byte[] in, int inOff, int len)
    {
        bOut.write(in, inOff, len);
    }

    public int doFinal(byte[] out, int outOff)
    {
        byte[] res = bOut.toByteArray();

        System.arraycopy(res, 0, out, outOff, res.length);

        reset();
        
        return res.length;
    }

    public void reset()
    {
        bOut.reset();
    }
}