<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
=======
package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;


public class McElieceCCA2KeyParameters
    extends AsymmetricKeyParameter
{
    private String params;

    public McElieceCCA2KeyParameters(
        boolean isPrivate,
        String params)
    {
        super(isPrivate);
        this.params = params;
    }


    public String getDigest()
    {
        return params;
    }

}
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
