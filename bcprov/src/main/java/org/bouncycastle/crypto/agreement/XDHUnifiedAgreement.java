<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.crypto.agreement;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.RawAgreement;
import org.bouncycastle.crypto.params.XDHUPrivateParameters;
import org.bouncycastle.crypto.params.XDHUPublicParameters;

public class XDHUnifiedAgreement
    implements RawAgreement
{
    private final RawAgreement xAgreement;

    private XDHUPrivateParameters privParams;

    public XDHUnifiedAgreement(RawAgreement xAgreement)
    {
        this.xAgreement = xAgreement;
    }

    public void init(
        CipherParameters key)
    {
        this.privParams = (XDHUPrivateParameters)key;

        xAgreement.init(privParams.getStaticPrivateKey());  // constraint check
    }

    public int getAgreementSize()
    {
        return xAgreement.getAgreementSize() * 2;
    }

    public void calculateAgreement(CipherParameters publicKey, byte[] buf, int off)
    {
        XDHUPublicParameters pubParams = (XDHUPublicParameters)publicKey;

        xAgreement.init(privParams.getEphemeralPrivateKey());

        xAgreement.calculateAgreement(pubParams.getEphemeralPublicKey(), buf, off);

        xAgreement.init(privParams.getStaticPrivateKey());

        xAgreement.calculateAgreement(pubParams.getStaticPublicKey(), buf, off + xAgreement.getAgreementSize());
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
