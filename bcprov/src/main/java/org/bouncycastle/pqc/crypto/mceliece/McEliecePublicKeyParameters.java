<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
=======
package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;


public class McEliecePublicKeyParameters
    extends McElieceKeyParameters
{
    // the length of the code
    private int n;

    // the error correction capability of the code
    private int t;

    // the generator matrix
    private GF2Matrix g;

    /**
     * Constructor.
     *
     * @param n      the length of the code
     * @param t      the error correction capability of the code
     * @param g      the generator matrix
     */
    public McEliecePublicKeyParameters(int n, int t, GF2Matrix g)
    {
        super(false, null);
        this.n = n;
        this.t = t;
        this.g = new GF2Matrix(g);
    }

    /**
     * @return the length of the code
     */
    public int getN()
    {
        return n;
    }

    /**
     * @return the error correction capability of the code
     */
    public int getT()
    {
        return t;
    }

    /**
     * @return the generator matrix
     */
    public GF2Matrix getG()
    {
        return g;
    }

    /**
     * @return the dimension of the code
     */
    public int getK()
    {
        return g.getNumRows();
    }

}
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
