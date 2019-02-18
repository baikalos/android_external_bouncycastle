package org.bouncycastle.cms;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
// Android-removed: Unsupported algorithms
// import org.bouncycastle.asn1.cms.OtherRevocationInfoFormat;
// import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Store;

class CMSSignedHelper
{
    static final CMSSignedHelper INSTANCE = new CMSSignedHelper();

    private static final Map     encryptionAlgs = new HashMap();

    private static void addEntries(ASN1ObjectIdentifier alias, String encryption)
    {
        encryptionAlgs.put(alias.getId(), encryption);
    }

    static
    {
<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
        addEntries(NISTObjectIdentifiers.dsa_with_sha224, "SHA224", "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha256, "SHA256", "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha384, "SHA384", "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha512, "SHA512", "DSA");
        addEntries(OIWObjectIdentifiers.dsaWithSHA1, "SHA1", "DSA");
        // BEGIN Android-removed: Unsupported algorithms
        // addEntries(OIWObjectIdentifiers.md4WithRSA, "MD4", "RSA");
        // addEntries(OIWObjectIdentifiers.md4WithRSAEncryption, "MD4", "RSA");
        // END Android-removed: Unsupported algorithms
        addEntries(OIWObjectIdentifiers.md5WithRSA, "MD5", "RSA");
        addEntries(OIWObjectIdentifiers.sha1WithRSA, "SHA1", "RSA");
        // BEGIN Android-removed: Unsupported algorithms
        // addEntries(PKCSObjectIdentifiers.md2WithRSAEncryption, "MD2", "RSA");
        // addEntries(PKCSObjectIdentifiers.md4WithRSAEncryption, "MD4", "RSA");
        // END Android-removed: Unsupported algorithms
        addEntries(PKCSObjectIdentifiers.md5WithRSAEncryption, "MD5", "RSA");
        addEntries(PKCSObjectIdentifiers.sha1WithRSAEncryption, "SHA1", "RSA");
        addEntries(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224", "RSA");
        addEntries(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256", "RSA");
        addEntries(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384", "RSA");
        addEntries(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512", "RSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1", "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224", "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256", "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384", "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512", "ECDSA");
        addEntries(X9ObjectIdentifiers.id_dsa_with_sha1, "SHA1", "DSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512", "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_1, "SHA1", "RSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_256, "SHA256", "RSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_PSS_SHA_1, "SHA1", "RSAandMGF1");
        addEntries(EACObjectIdentifiers.id_TA_RSA_PSS_SHA_256, "SHA256", "RSAandMGF1");
=======
        addEntries(NISTObjectIdentifiers.dsa_with_sha224, "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha256, "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha384, "DSA");
        addEntries(NISTObjectIdentifiers.dsa_with_sha512,  "DSA");
        addEntries(NISTObjectIdentifiers.id_dsa_with_sha3_224, "DSA");
        addEntries(NISTObjectIdentifiers.id_dsa_with_sha3_256, "DSA");
        addEntries(NISTObjectIdentifiers.id_dsa_with_sha3_384,  "DSA");
        addEntries(NISTObjectIdentifiers.id_dsa_with_sha3_512,  "DSA");
        addEntries(OIWObjectIdentifiers.dsaWithSHA1,  "DSA");
        addEntries(OIWObjectIdentifiers.md4WithRSA, "RSA");
        addEntries(OIWObjectIdentifiers.md4WithRSAEncryption, "RSA");
        addEntries(OIWObjectIdentifiers.md5WithRSA,  "RSA");
        addEntries(OIWObjectIdentifiers.sha1WithRSA,  "RSA");
        addEntries(PKCSObjectIdentifiers.md2WithRSAEncryption,  "RSA");
        addEntries(PKCSObjectIdentifiers.md4WithRSAEncryption,  "RSA");
        addEntries(PKCSObjectIdentifiers.md5WithRSAEncryption,  "RSA");
        addEntries(PKCSObjectIdentifiers.sha1WithRSAEncryption,  "RSA");
        addEntries(PKCSObjectIdentifiers.sha224WithRSAEncryption,  "RSA");
        addEntries(PKCSObjectIdentifiers.sha256WithRSAEncryption, "RSA");
        addEntries(PKCSObjectIdentifiers.sha384WithRSAEncryption,  "RSA");
        addEntries(PKCSObjectIdentifiers.sha512WithRSAEncryption,  "RSA");
        addEntries(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_224,  "RSA");
        addEntries(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_256,  "RSA");
        addEntries(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_384,  "RSA");
        addEntries(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_512,  "RSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA1,  "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA224,  "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA256,  "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA384,  "ECDSA");
        addEntries(X9ObjectIdentifiers.ecdsa_with_SHA512, "ECDSA");
        addEntries(NISTObjectIdentifiers.id_ecdsa_with_sha3_224,  "ECDSA");
        addEntries(NISTObjectIdentifiers.id_ecdsa_with_sha3_256,  "ECDSA");
        addEntries(NISTObjectIdentifiers.id_ecdsa_with_sha3_384, "ECDSA");
        addEntries(NISTObjectIdentifiers.id_ecdsa_with_sha3_512,  "ECDSA");
        addEntries(X9ObjectIdentifiers.id_dsa_with_sha1,  "DSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_1,  "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_224,  "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_256,  "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_384,  "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_ECDSA_SHA_512,  "ECDSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_1,  "RSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_256, "RSA");
        addEntries(EACObjectIdentifiers.id_TA_RSA_PSS_SHA_1,  "RSAandMGF1");
        addEntries(EACObjectIdentifiers.id_TA_RSA_PSS_SHA_256, "RSAandMGF1");
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)

<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
        encryptionAlgs.put(X9ObjectIdentifiers.id_dsa.getId(), "DSA");
        encryptionAlgs.put(PKCSObjectIdentifiers.rsaEncryption.getId(), "RSA");
        encryptionAlgs.put(TeleTrusTObjectIdentifiers.teleTrusTRSAsignatureAlgorithm, "RSA");
        encryptionAlgs.put(X509ObjectIdentifiers.id_ea_rsa.getId(), "RSA");
        // BEGIN Android-removed: Unsupported algorithms
        /*
        encryptionAlgs.put(CMSSignedDataGenerator.ENCRYPTION_RSA_PSS, "RSAandMGF1");
        encryptionAlgs.put(CryptoProObjectIdentifiers.gostR3410_94.getId(), "GOST3410");
        encryptionAlgs.put(CryptoProObjectIdentifiers.gostR3410_2001.getId(), "ECGOST3410");
        encryptionAlgs.put("1.3.6.1.4.1.5849.1.6.2", "ECGOST3410");
        encryptionAlgs.put("1.3.6.1.4.1.5849.1.1.5", "GOST3410");
        encryptionAlgs.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001.getId(), "ECGOST3410");
        encryptionAlgs.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94.getId(), "GOST3410");

        digestAlgs.put(PKCSObjectIdentifiers.md2.getId(), "MD2");
        digestAlgs.put(PKCSObjectIdentifiers.md4.getId(), "MD4");
        */
        // END Android-removed: Unsupported algorithms
        digestAlgs.put(PKCSObjectIdentifiers.md5.getId(), "MD5");
        digestAlgs.put(OIWObjectIdentifiers.idSHA1.getId(), "SHA1");
        digestAlgs.put(NISTObjectIdentifiers.id_sha224.getId(), "SHA224");
        digestAlgs.put(NISTObjectIdentifiers.id_sha256.getId(), "SHA256");
        digestAlgs.put(NISTObjectIdentifiers.id_sha384.getId(), "SHA384");
        digestAlgs.put(NISTObjectIdentifiers.id_sha512.getId(), "SHA512");
        // BEGIN Android-removed: Unsupported algorithms
        // digestAlgs.put(TeleTrusTObjectIdentifiers.ripemd128.getId(), "RIPEMD128");
        // digestAlgs.put(TeleTrusTObjectIdentifiers.ripemd160.getId(), "RIPEMD160");
        // digestAlgs.put(TeleTrusTObjectIdentifiers.ripemd256.getId(), "RIPEMD256");
        // digestAlgs.put(CryptoProObjectIdentifiers.gostR3411.getId(),  "GOST3411");
        // digestAlgs.put("1.3.6.1.4.1.5849.1.2.1",  "GOST3411");
        // END Android-removed: Unsupported algorithms

        digestAliases.put("SHA1", new String[] { "SHA-1" });
        digestAliases.put("SHA224", new String[] { "SHA-224" });
        digestAliases.put("SHA256", new String[] { "SHA-256" });
        digestAliases.put("SHA384", new String[] { "SHA-384" });
        digestAliases.put("SHA512", new String[] { "SHA-512" });
=======
        addEntries(X9ObjectIdentifiers.id_dsa, "DSA");
        addEntries(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        addEntries(TeleTrusTObjectIdentifiers.teleTrusTRSAsignatureAlgorithm, "RSA");
        addEntries(X509ObjectIdentifiers.id_ea_rsa, "RSA");
        addEntries(PKCSObjectIdentifiers.id_RSASSA_PSS, "RSAandMGF1");
        addEntries(CryptoProObjectIdentifiers.gostR3410_94, "GOST3410");
        addEntries(CryptoProObjectIdentifiers.gostR3410_2001, "ECGOST3410");
        addEntries(new ASN1ObjectIdentifier("1.3.6.1.4.1.5849.1.6.2"), "ECGOST3410");
        addEntries(new ASN1ObjectIdentifier("1.3.6.1.4.1.5849.1.1.5"), "GOST3410");
        addEntries(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256, "ECGOST3410-2012-256");
        addEntries(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512, "ECGOST3410-2012-512");
        addEntries(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "ECGOST3410");
        addEntries(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3410");
        addEntries(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "ECGOST3410-2012-256");
        addEntries(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "ECGOST3410-2012-512");
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
    }


    /**
     * Return the digest encryption algorithm using one of the standard
     * JCA string representations rather the the algorithm identifier (if
     * possible).
     */
    String getEncryptionAlgName(
        String encryptionAlgOID)
    {
        String algName = (String)encryptionAlgs.get(encryptionAlgOID);

        if (algName != null)
        {
            return algName;
        }

        return encryptionAlgOID;
    }

    AlgorithmIdentifier fixAlgID(AlgorithmIdentifier algId)
    {
        if (algId.getParameters() == null)
        {
            return new AlgorithmIdentifier(algId.getAlgorithm(), DERNull.INSTANCE);
        }

        return algId;
    }

    void setSigningEncryptionAlgorithmMapping(ASN1ObjectIdentifier oid, String algorithmName)
    {
        addEntries(oid, algorithmName);
    }

    Store getCertificates(ASN1Set certSet)
    {
        if (certSet != null)
        {
            List certList = new ArrayList(certSet.size());

            for (Enumeration en = certSet.getObjects(); en.hasMoreElements();)
            {
                ASN1Primitive obj = ((ASN1Encodable)en.nextElement()).toASN1Primitive();

                if (obj instanceof ASN1Sequence)
                {
                    certList.add(new X509CertificateHolder(Certificate.getInstance(obj)));
                }
            }

            return new CollectionStore(certList);
        }

        return new CollectionStore(new ArrayList());
    }

    Store getAttributeCertificates(ASN1Set certSet)
    {
        if (certSet != null)
        {
            List certList = new ArrayList(certSet.size());

            for (Enumeration en = certSet.getObjects(); en.hasMoreElements();)
            {
                ASN1Primitive obj = ((ASN1Encodable)en.nextElement()).toASN1Primitive();

                if (obj instanceof ASN1TaggedObject)
                {
                    certList.add(new X509AttributeCertificateHolder(AttributeCertificate.getInstance(((ASN1TaggedObject)obj).getObject())));
                }
            }

            return new CollectionStore(certList);
        }

        return new CollectionStore(new ArrayList());
    }

    Store getCRLs(ASN1Set crlSet)
    {
        if (crlSet != null)
        {
            List crlList = new ArrayList(crlSet.size());

            for (Enumeration en = crlSet.getObjects(); en.hasMoreElements();)
            {
                ASN1Primitive obj = ((ASN1Encodable)en.nextElement()).toASN1Primitive();

                if (obj instanceof ASN1Sequence)
                {
                    crlList.add(new X509CRLHolder(CertificateList.getInstance(obj)));
                }
            }

            return new CollectionStore(crlList);
        }

        return new CollectionStore(new ArrayList());
    }

    // BEGIN Android-removed: OtherRevocationInfoFormat isn't supported
    /*
    Store getOtherRevocationInfo(ASN1ObjectIdentifier otherRevocationInfoFormat, ASN1Set crlSet)
    {
        if (crlSet != null)
        {
            List    crlList = new ArrayList(crlSet.size());

            for (Enumeration en = crlSet.getObjects(); en.hasMoreElements();)
            {
                ASN1Primitive obj = ((ASN1Encodable)en.nextElement()).toASN1Primitive();

                if (obj instanceof ASN1TaggedObject)
                {
                    ASN1TaggedObject tObj = ASN1TaggedObject.getInstance(obj);

                    if (tObj.getTagNo() == 1)
                    {
                        OtherRevocationInfoFormat other = OtherRevocationInfoFormat.getInstance(tObj, false);

                        if (otherRevocationInfoFormat.equals(other.getInfoFormat()))
                        {
                            crlList.add(other.getInfo());
                        }
                    }
                }
            }

            return new CollectionStore(crlList);
        }

        return new CollectionStore(new ArrayList());
    }
    */
    // END Android-removed: OtherRevocationInfoFormat isn't supported
}
