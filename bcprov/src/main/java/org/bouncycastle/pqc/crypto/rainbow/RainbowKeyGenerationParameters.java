<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;

import org.bouncycastle.crypto.KeyGenerationParameters;

public class RainbowKeyGenerationParameters
    extends KeyGenerationParameters
{
    private RainbowParameters params;

    public RainbowKeyGenerationParameters(
        SecureRandom random,
        RainbowParameters params
    )
    {

        // TODO: actual strength
        super(random, 256);
        this.params = params;
    }

    public RainbowParameters getParameters()
    {
        return params;
    }
}

>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
