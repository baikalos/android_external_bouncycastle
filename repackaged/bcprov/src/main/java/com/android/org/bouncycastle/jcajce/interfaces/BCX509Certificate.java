/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.org.bouncycastle.jcajce.interfaces;

import com.android.org.bouncycastle.asn1.x500.X500Name;
import com.android.org.bouncycastle.asn1.x509.TBSCertificate;

/**
 * @hide This class is not part of the Android public SDK API
 */
public interface BCX509Certificate
{
    X500Name getIssuerX500Name();
    TBSCertificate getTBSCertificateNative();
    X500Name getSubjectX500Name();
}
