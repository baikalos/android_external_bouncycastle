<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.crypto.params;

import java.security.SecureRandom;

import org.bouncycastle.crypto.KeyGenerationParameters;

public class CramerShoupKeyGenerationParameters
    extends KeyGenerationParameters
{

    private CramerShoupParameters params;

    public CramerShoupKeyGenerationParameters(SecureRandom random, CramerShoupParameters params)
    {
        super(random, getStrength(params));

        this.params = params;
    }

    public CramerShoupParameters getParameters()
    {
        return params;
    }

    static int getStrength(CramerShoupParameters params)
    {
        return params.getP().bitLength();
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
