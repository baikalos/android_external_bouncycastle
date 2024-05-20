<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters
    extends CramerShoupKeyParameters
{

    private BigInteger c, d, h; // public key group elements

    public CramerShoupPublicKeyParameters(CramerShoupParameters params, BigInteger c, BigInteger d, BigInteger h)
    {
        super(false, params);

        this.c = c;
        this.d = d;
        this.h = h;
    }

    public BigInteger getC()
    {
        return c;
    }

    public BigInteger getD()
    {
        return d;
    }

    public BigInteger getH()
    {
        return h;
    }

    public int hashCode()
    {
        return c.hashCode() ^ d.hashCode() ^ h.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof CramerShoupPublicKeyParameters))
        {
            return false;
        }

        CramerShoupPublicKeyParameters other = (CramerShoupPublicKeyParameters)obj;

        return other.getC().equals(c) && other.getD().equals(d) && other.getH().equals(h) && super.equals(obj);
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
