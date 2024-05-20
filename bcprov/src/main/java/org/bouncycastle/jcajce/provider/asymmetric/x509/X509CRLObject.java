package org.bouncycastle.jcajce.provider.asymmetric.x509;

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
import java.io.IOException;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
import java.security.cert.CRLException;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.jcajce.util.JcaJceHelper;
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
import org.bouncycastle.util.Arrays;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

class X509CRLObject
    extends X509CRLImpl
{
    private final Object        cacheLock = new Object();
    private X509CRLInternal     internalCRLValue;

    private volatile boolean    hashValueSet;
    private volatile int        hashValue;

    X509CRLObject(JcaJceHelper bcHelper, CertificateList c) throws CRLException
    {
        super(bcHelper, c, createSigAlgName(c), createSigAlgParams(c), isIndirectCRL(c));
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
    }

    public byte[] getEncoded() throws CRLException
    {
        return Arrays.clone(getInternalCRL().getEncoded());
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }

        if (other instanceof X509CRLObject)
        {
            X509CRLObject otherBC = (X509CRLObject)other;

            if (this.hashValueSet && otherBC.hashValueSet)
            {
                if (this.hashValue != otherBC.hashValue)
                {
                    return false;
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
                }
            }
            else if (null == internalCRLValue || null == otherBC.internalCRLValue)
            {
                ASN1BitString signature = c.getSignature();
                if (null != signature && !signature.equals(otherBC.c.getSignature()))
                {
                    return false;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
                }
            }
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
            else if (null == internalCRLValue || null == otherBC.internalCRLValue)
            {
                ASN1BitString signature = c.getSignature();
                if (null != signature && !signature.equals(otherBC.c.getSignature()))
                {
                    return false;
                }
            }
=======

            return getInternalCRL().equals(otherBC.getInternalCRL());
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        }

        return getInternalCRL().equals(other);
    }

    public int hashCode()
    {
        if (!hashValueSet)
        {
            hashValue = getInternalCRL().hashCode();
            hashValueSet = true;
        }

        return hashValue;
    }

    private X509CRLInternal getInternalCRL()
    {
        synchronized (cacheLock)
        {
            if (null != internalCRLValue)
            {
                return internalCRLValue;
            }
        }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        byte[] encoding;
        try
        {
            encoding = getEncoded();
        }
        catch (CRLException e)
        {
            encoding = null;
        }

        X509CRLInternal temp = new X509CRLInternal(bcHelper, c, sigAlgName,sigAlgParams, isIndirect, encoding);

        synchronized (cacheLock)
        {
            if (null == internalCRLValue)
            {
                internalCRLValue = temp;
            }

            return internalCRLValue;
        }
    }

    private static String createSigAlgName(CertificateList c) throws CRLException
    {
        try
        {
            return X509SignatureUtil.getSignatureName(c.getSignatureAlgorithm());
        }
        catch (Exception e)
        {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    private static byte[] createSigAlgParams(CertificateList c) throws CRLException
    {
        try
        {
            ASN1Encodable parameters = c.getSignatureAlgorithm().getParameters();
            if (null == parameters)
            {
                return null;
            }

            return parameters.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        }
        catch (Exception e)
        {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    private static boolean isIndirectCRL(CertificateList c) throws CRLException
    {
        try
        {
            byte[] extOctets = getExtensionOctets(c, Extension.issuingDistributionPoint.getId());
            if (null == extOctets)
            {
                return false;
            }

            return IssuingDistributionPoint.getInstance(extOctets).isIndirectCRL();
        }
        catch (Exception e)
        {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e);
=======
        byte[] encoding = null;
        CRLException exception = null;
        try
        {
            encoding = c.getEncoded(ASN1Encoding.DER);
        }
        catch (IOException e)
        {
            exception = new X509CRLException(e);
        }

        X509CRLInternal temp = new X509CRLInternal(bcHelper, c, sigAlgName,sigAlgParams, isIndirect, encoding,
            exception);

        synchronized (cacheLock)
        {
            if (null == internalCRLValue)
            {
                internalCRLValue = temp;
            }

            return internalCRLValue;
        }
    }

    private static String createSigAlgName(CertificateList c) throws CRLException
    {
        try
        {
            return X509SignatureUtil.getSignatureName(c.getSignatureAlgorithm());
        }
        catch (Exception e)
        {
            throw new X509CRLException("CRL contents invalid: " + e.getMessage(), e);
        }
    }

    private static byte[] createSigAlgParams(CertificateList c) throws CRLException
    {
        try
        {
            ASN1Encodable parameters = c.getSignatureAlgorithm().getParameters();
            if (null == parameters)
            {
                return null;
            }

            return parameters.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        }
        catch (Exception e)
        {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    private static boolean isIndirectCRL(CertificateList c) throws CRLException
    {
        try
        {
            byte[] extOctets = getExtensionOctets(c, Extension.issuingDistributionPoint.getId());
            if (null == extOctets)
            {
                return false;
            }

            return IssuingDistributionPoint.getInstance(extOctets).isIndirectCRL();
        }
        catch (Exception e)
        {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e);
        }
    }

    private static class X509CRLException
        extends CRLException
    {
        private final Throwable cause;

        X509CRLException(String msg, Throwable cause)
        {
            super(msg);
            this.cause = cause;
        }

        X509CRLException(Throwable cause)
        {
            this.cause = cause;
        }

        public Throwable getCause()
        {
            return cause;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        }
    }
}
