<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
=======
package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.util.BigIntegers;

class ECUtil
{
    static BigInteger generateK(BigInteger n, SecureRandom random)
    {
        int nBitLength = n.bitLength();
        BigInteger k;
        do
        {
            k = BigIntegers.createRandomBigInteger(nBitLength, random);
        }
        while (k.equals(ECConstants.ZERO) || (k.compareTo(n) >= 0));
        return k;
    }
}
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
