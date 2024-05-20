<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.crypto.engines;

/**
 * An implementation of the Camellia key wrapper based on RFC 3657/RFC 3394.
 * <p>
 * For further details see: <a href="https://www.ietf.org/rfc/rfc3657.txt">https://www.ietf.org/rfc/rfc3657.txt</a>.
 */
public class CamelliaWrapEngine
    extends RFC3394WrapEngine
{
    public CamelliaWrapEngine()
    {
        super(new CamelliaEngine());
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
