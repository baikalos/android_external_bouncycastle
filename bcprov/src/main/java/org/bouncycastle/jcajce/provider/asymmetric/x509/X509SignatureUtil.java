package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
// BEGIN android-removed
// import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
// END android-removed
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
=======
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
// BEGIN android-removed
// import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
// END android-removed
=======
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.util.MessageDigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

class X509SignatureUtil
{
    private static final ASN1Null       derNull = DERNull.INSTANCE;

    static void setSignatureParameters(
        Signature signature,
        ASN1Encodable params)
        throws NoSuchAlgorithmException, SignatureException, InvalidKeyException
    {
        if (params != null && !derNull.equals(params))
        {
            AlgorithmParameters  sigParams = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            
            try
            {
                sigParams.init(params.toASN1Primitive().getEncoded());
            }
            catch (IOException e)
            {
                throw new SignatureException("IOException decoding parameters: " + e.getMessage());
            }
            
            if (signature.getAlgorithm().endsWith("MGF1"))
            {
                try
                {
                    signature.setParameter(sigParams.getParameterSpec(PSSParameterSpec.class));
                }
                catch (GeneralSecurityException e)
                {
                    throw new SignatureException("Exception extracting parameters: " + e.getMessage());
                }
            }
        }
    }
    
    static String getSignatureName(
        AlgorithmIdentifier sigAlgId) 
    {
        ASN1Encodable params = sigAlgId.getParameters();
        
        if (params != null && !derNull.equals(params))
        {
            if (sigAlgId.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS))
            {
                RSASSAPSSparams rsaParams = RSASSAPSSparams.getInstance(params);
                
                return getDigestAlgName(rsaParams.getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
            }
            if (sigAlgId.getAlgorithm().equals(X9ObjectIdentifiers.ecdsa_with_SHA2))
            {
                ASN1Sequence ecDsaParams = ASN1Sequence.getInstance(params);
                
                return getDigestAlgName((ASN1ObjectIdentifier)ecDsaParams.getObjectAt(0)) + "withECDSA";
            }
        }

        Provider prov = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);

        if (prov != null)
        {
            String      algName = prov.getProperty("Alg.Alias.Signature." + sigAlgId.getAlgorithm().getId());

            if (algName != null)
            {
                return algName;
            }
        }

        Provider[] provs = Security.getProviders();

        //
        // search every provider looking for a real algorithm
        //
        for (int i = 0; i != provs.length; i++)
        {
            String algName = provs[i].getProperty("Alg.Alias.Signature." + sigAlgId.getAlgorithm().getId());
            if (algName != null)
            {
                return algName;
            }
        }

        return sigAlgId.getAlgorithm().getId();
    }
    
    /**
     * Return the digest algorithm using one of the standard JCA string
     * representations rather the the algorithm identifier (if possible).
     */
    private static String getDigestAlgName(
        ASN1ObjectIdentifier digestAlgOID)
    {
        String name = MessageDigestUtils.getDigestName(digestAlgOID);

        int dIndex = name.indexOf('-');
        if (dIndex > 0 && !name.startsWith("SHA3"))
        {
            return name.substring(0, dIndex) + name.substring(dIndex + 1);
        }
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
        else if (OIWObjectIdentifiers.idSHA1.equals(digestAlgOID))
        {
            return "SHA1";
        }
        else if (NISTObjectIdentifiers.id_sha224.equals(digestAlgOID))
        {
            return "SHA224";
        }
        else if (NISTObjectIdentifiers.id_sha256.equals(digestAlgOID))
        {
            return "SHA256";
        }
        else if (NISTObjectIdentifiers.id_sha384.equals(digestAlgOID))
        {
            return "SHA384";
        }
        else if (NISTObjectIdentifiers.id_sha512.equals(digestAlgOID))
        {
            return "SHA512";
        }
        // BEGIN android-removed
        // else if (TeleTrusTObjectIdentifiers.ripemd128.equals(digestAlgOID))
        // {
        //     return "RIPEMD128";
        // }
        // else if (TeleTrusTObjectIdentifiers.ripemd160.equals(digestAlgOID))
        // {
        //     return "RIPEMD160";
        // }
        // else if (TeleTrusTObjectIdentifiers.ripemd256.equals(digestAlgOID))
        // {
        //     return "RIPEMD256";
        // }
        // else if (CryptoProObjectIdentifiers.gostR3411.equals(digestAlgOID))
        // {
        //     return "GOST3411";
        // }
        // END android-removed
        else
        {
            return digestAlgOID.getId();            
        }
=======

        return MessageDigestUtils.getDigestName(digestAlgOID);
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
    }
}
