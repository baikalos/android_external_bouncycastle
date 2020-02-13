<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A generic interface for key exchange implementations in (D)TLS.
 *
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public interface TlsKeyExchange
{
    void init(TlsContext context);

    void skipServerCredentials()
        throws IOException;

    void processServerCredentials(TlsCredentials serverCredentials)
        throws IOException;

    void processServerCertificate(Certificate serverCertificate)
        throws IOException;

    boolean requiresServerKeyExchange();

    byte[] generateServerKeyExchange()
        throws IOException;

    void skipServerKeyExchange()
        throws IOException;

    void processServerKeyExchange(InputStream input)
        throws IOException;

    void validateCertificateRequest(CertificateRequest certificateRequest)
        throws IOException;

    void skipClientCredentials()
        throws IOException;

    void processClientCredentials(TlsCredentials clientCredentials)
        throws IOException;

    void processClientCertificate(Certificate clientCertificate)
        throws IOException;

    void generateClientKeyExchange(OutputStream output)
        throws IOException;

    void processClientKeyExchange(InputStream input)
        throws IOException;

    byte[] generatePremasterSecret()
        throws IOException;
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
