<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class RainbowKeyParameters
    extends AsymmetricKeyParameter
{
    private final RainbowParameters params;
    private final int docLength;

    public RainbowKeyParameters(boolean isPrivateKey, RainbowParameters params)
    {
        super(isPrivateKey);
        this.params = params;
        this.docLength = params.getM();
    }

    public RainbowParameters getParameters()
    {
        return params;
    }

    /**
     * @return the docLength
     */
    public int getDocLength()
    {
        return this.docLength;
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
