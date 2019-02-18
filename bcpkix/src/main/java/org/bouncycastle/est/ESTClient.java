<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
=======
package org.bouncycastle.est;

import java.io.IOException;

/**
 * ESTClient implement connection to the server.
 * <p>
 * Implementations should be aware that they are responsible for
 * satisfying <a href="https://tools.ietf.org/html/rfc7030#section-3.3">RFC7030 3.3 - TLS Layer</a>
 * including SRP modes.
 */
public interface ESTClient
{
    public ESTResponse doRequest(ESTRequest c)
        throws IOException;
}
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
