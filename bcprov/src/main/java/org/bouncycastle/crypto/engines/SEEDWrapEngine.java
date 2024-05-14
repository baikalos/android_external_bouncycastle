<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.crypto.engines;

/**
 * An implementation of the SEED key wrapper based on RFC 4010/RFC 3394.
 * <p>
 * For further details see: <a href="https://www.ietf.org/rfc/rfc4010.txt">https://www.ietf.org/rfc/rfc4010.txt</a>.
 */
public class SEEDWrapEngine
    extends RFC3394WrapEngine
{
    public SEEDWrapEngine()
    {
        super(new SEEDEngine());
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
