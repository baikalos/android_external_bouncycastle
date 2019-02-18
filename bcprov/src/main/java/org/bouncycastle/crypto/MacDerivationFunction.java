<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
=======
package org.bouncycastle.crypto;

/**
 * base interface for general purpose Mac based byte derivation functions.
 */
public interface MacDerivationFunction
    extends DerivationFunction
{
    /**
     * return the MAC used as the basis for the function
     *
     * @return the Mac.
     */
    public Mac getMac();
}
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
