/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.org.bouncycastle.cert.ocsp.jcajce;

import java.math.BigInteger;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import com.android.org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import com.android.org.bouncycastle.cert.ocsp.CertificateID;
import com.android.org.bouncycastle.cert.ocsp.OCSPException;
import com.android.org.bouncycastle.operator.DigestCalculator;

public class JcaCertificateID
    extends CertificateID
{
    public JcaCertificateID(DigestCalculator digestCalculator, X509Certificate issuerCert, BigInteger number)
        throws OCSPException, CertificateEncodingException
    {
        super(digestCalculator, new JcaX509CertificateHolder(issuerCert), number);
    }
}
