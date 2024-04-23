package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CertificateEncodingException;

import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.jcajce.util.JcaJceHelper;

<<<<<<< HEAD
class X509CertificateInternal extends X509CertificateImpl
{
    private final byte[] encoding;

    X509CertificateInternal(JcaJceHelper bcHelper, org.bouncycastle.asn1.x509.Certificate c,
        BasicConstraints basicConstraints, boolean[] keyUsage, String sigAlgName, byte[] sigAlgParams, byte[] encoding)
=======
/**
 * This class exists to let {@link #equals(Object)} and {@link #hashCode()} methods be delegated efficiently
 * to the platform default implementations (especially important for compatibility of {@link #hashCode()}
 * calculations). Those methods fall back to calling {@link #getEncoded()} for third-party subclasses, and
 * this class allows us to avoid cloning the return value of {@link #getEncoded()} for those callers.
 */
class X509CertificateInternal extends X509CertificateImpl
{
    private final byte[] encoding;
    private final CertificateEncodingException exception;

    X509CertificateInternal(JcaJceHelper bcHelper, org.bouncycastle.asn1.x509.Certificate c,
        BasicConstraints basicConstraints, boolean[] keyUsage, String sigAlgName, byte[] sigAlgParams, byte[] encoding,
        CertificateEncodingException exception)
>>>>>>> aosp/upstream-master
    {
        super(bcHelper, c, basicConstraints, keyUsage, sigAlgName, sigAlgParams);

        this.encoding = encoding;
<<<<<<< HEAD
=======
        this.exception = exception;
>>>>>>> aosp/upstream-master
    }

    public byte[] getEncoded() throws CertificateEncodingException
    {
<<<<<<< HEAD
=======
        if (null != exception)
        {
            throw exception;
        }

>>>>>>> aosp/upstream-master
        if (null == encoding)
        {
            throw new CertificateEncodingException();
        }

<<<<<<< HEAD
=======
        /*
         * NOTE: Don't clone this return value. See class javadoc for details. Any necessary cloning is
         * handled by the X509CertificateObject that is holding this instance.
         */
>>>>>>> aosp/upstream-master
        return encoding;
    }
}
