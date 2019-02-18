<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
=======
package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.util.Arrays;

public class SPHINCSPublicKeyParameters
    extends SPHINCSKeyParameters
{
    private final byte[] keyData;

    public SPHINCSPublicKeyParameters(byte[] keyData)
    {
        super(false, null);
        this.keyData = Arrays.clone(keyData);
    }

    public SPHINCSPublicKeyParameters(byte[] keyData, String treeDigest)
    {

        super(false, treeDigest);
        this.keyData = Arrays.clone(keyData);
    }

    public byte[] getKeyData()
    {
        return Arrays.clone(keyData);
    }
}
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
