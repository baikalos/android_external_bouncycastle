<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.signers.DSASigner;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;

/**
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public class TlsDSSSigner
    extends TlsDSASigner
{
    public boolean isValidPublicKey(AsymmetricKeyParameter publicKey)
    {
        return publicKey instanceof DSAPublicKeyParameters;
    }

    protected DSA createDSAImpl(short hashAlgorithm)
    {
        return new DSASigner(new HMacDSAKCalculator(TlsUtils.createHash(hashAlgorithm)));
    }

    protected short getSignatureAlgorithm()
    {
        return SignatureAlgorithm.dsa;
    }
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
