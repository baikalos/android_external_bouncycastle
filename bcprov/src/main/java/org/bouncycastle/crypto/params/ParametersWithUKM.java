<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithUKM
    implements CipherParameters
{
    private byte[] ukm;
    private CipherParameters    parameters;

    public ParametersWithUKM(
        CipherParameters    parameters,
        byte[] ukm)
    {
        this(parameters, ukm, 0, ukm.length);
    }

    public ParametersWithUKM(
        CipherParameters    parameters,
        byte[] ukm,
        int                 ukmOff,
        int                 ukmLen)
    {
        this.ukm = new byte[ukmLen];
        this.parameters = parameters;

        System.arraycopy(ukm, ukmOff, this.ukm, 0, ukmLen);
    }

    public byte[] getUKM()
    {
        return ukm;
    }

    public CipherParameters getParameters()
    {
        return parameters;
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
