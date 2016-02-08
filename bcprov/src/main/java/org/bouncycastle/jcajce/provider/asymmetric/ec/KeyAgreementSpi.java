package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
// BEGIN android-removed
// import org.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
// import org.bouncycastle.crypto.agreement.ECMQVBasicAgreement;
// import org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
// import org.bouncycastle.crypto.agreement.kdf.ECDHKEKGenerator;
// END android-removed
=======
import org.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
import org.bouncycastle.crypto.agreement.ECMQVBasicAgreement;
import org.bouncycastle.crypto.agreement.kdf.ConcatenationKDFGenerator;
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
// BEGIN android-removed
// import org.bouncycastle.crypto.params.MQVPrivateParameters;
// import org.bouncycastle.crypto.params.MQVPublicParameters;
// END android-removed
=======
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.MQVParameterSpec;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
// BEGIN android-removed
// import org.bouncycastle.jce.interfaces.MQVPrivateKey;
// import org.bouncycastle.jce.interfaces.MQVPublicKey;
// END android-removed
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;
=======
import org.bouncycastle.jce.interfaces.MQVPrivateKey;
import org.bouncycastle.jce.interfaces.MQVPublicKey;
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)

/**
 * Diffie-Hellman key agreement using elliptic curve keys, ala IEEE P1363
 * both the simple one, and the simple one with cofactors are supported.
 *
 * Also, MQV key agreement per SEC-1
 */
public class KeyAgreementSpi
    extends BaseAgreementSpi
{
    private static final X9IntegerConverter converter = new X9IntegerConverter();

    private String                 kaAlgorithm;

    private ECDomainParameters     parameters;
    private BasicAgreement         agreement;
<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
    // BEGIN android-removed
    // private DerivationFunction     kdf;
    // END android-removed
=======
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)

    private MQVParameterSpec       mqvParameters;

    protected KeyAgreementSpi(
        String kaAlgorithm,
        BasicAgreement agreement,
        DerivationFunction kdf)
    {
        super(kaAlgorithm, kdf);

        this.kaAlgorithm = kaAlgorithm;
        this.agreement = agreement;
<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
        // BEGIN android-removed
        // this.kdf = kdf;
        // END android-removed
=======
    }

    protected byte[] bigIntToBytes(
        BigInteger    r)
    {
        return converter.integerToBytes(r, converter.getByteLength(parameters.getCurve()));
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
    }

    protected Key engineDoPhase(
        Key     key,
        boolean lastPhase) 
        throws InvalidKeyException, IllegalStateException
    {
        if (parameters == null)
        {
            throw new IllegalStateException(kaAlgorithm + " not initialised.");
        }

        if (!lastPhase)
        {
            throw new IllegalStateException(kaAlgorithm + " can only be between two parties.");
        }

        CipherParameters pubKey;        
<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
        // BEGIN android-removed
        // if (agreement instanceof ECMQVBasicAgreement)
        // {
        //     if (!(key instanceof MQVPublicKey))
        //     {
        //         throw new InvalidKeyException(kaAlgorithm + " key agreement requires "
        //             + getSimpleName(MQVPublicKey.class) + " for doPhase");
        //     }
        //
        //     MQVPublicKey mqvPubKey = (MQVPublicKey)key;
        //     ECPublicKeyParameters staticKey = (ECPublicKeyParameters)
        //         ECUtil.generatePublicKeyParameter(mqvPubKey.getStaticKey());
        //     ECPublicKeyParameters ephemKey = (ECPublicKeyParameters)
        //         ECUtil.generatePublicKeyParameter(mqvPubKey.getEphemeralKey());
        //
        //     pubKey = new MQVPublicParameters(staticKey, ephemKey);
        //
        //     // TODO Validate that all the keys are using the same parameters?
        // }
        // else
        // END android-removed
=======
        if (agreement instanceof ECMQVBasicAgreement)
        {
            if (!(key instanceof MQVPublicKey))
            {
                ECPublicKeyParameters staticKey = (ECPublicKeyParameters)
                    ECUtil.generatePublicKeyParameter((PublicKey)key);
                ECPublicKeyParameters ephemKey = (ECPublicKeyParameters)
                    ECUtil.generatePublicKeyParameter(mqvParameters.getOtherPartyEphemeralKey());

                pubKey = new MQVPublicParameters(staticKey, ephemKey);
            }
            else
            {
                MQVPublicKey mqvPubKey = (MQVPublicKey)key;
                ECPublicKeyParameters staticKey = (ECPublicKeyParameters)
                    ECUtil.generatePublicKeyParameter(mqvPubKey.getStaticKey());
                ECPublicKeyParameters ephemKey = (ECPublicKeyParameters)
                    ECUtil.generatePublicKeyParameter(mqvPubKey.getEphemeralKey());

                pubKey = new MQVPublicParameters(staticKey, ephemKey);

                // TODO Validate that all the keys are using the same parameters?
            }
        }
        else
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
        {
            if (!(key instanceof PublicKey))
            {
                throw new InvalidKeyException(kaAlgorithm + " key agreement requires "
                    + getSimpleName(ECPublicKey.class) + " for doPhase");
            }

            pubKey = ECUtil.generatePublicKeyParameter((PublicKey)key);

            // TODO Validate that all the keys are using the same parameters?
        }

        result = agreement.calculateAgreement(pubKey);

        return null;
    }

<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
    protected byte[] engineGenerateSecret()
        throws IllegalStateException
    {
        // BEGIN android-removed
        // if (kdf != null)
        // {
        //     throw new UnsupportedOperationException(
        //         "KDF can only be used when algorithm is known");
        // }
        // END android-removed

        return bigIntToBytes(result);
    }

    protected int engineGenerateSecret(
        byte[]  sharedSecret,
        int     offset) 
        throws IllegalStateException, ShortBufferException
    {
        byte[] secret = engineGenerateSecret();

        if (sharedSecret.length - offset < secret.length)
        {
            throw new ShortBufferException(kaAlgorithm + " key agreement: need " + secret.length + " bytes");
        }

        System.arraycopy(secret, 0, sharedSecret, offset, secret.length);
        
        return secret.length;
    }

    protected SecretKey engineGenerateSecret(
        String algorithm)
        throws NoSuchAlgorithmException
    {
        byte[] secret = bigIntToBytes(result);
        String algKey = Strings.toUpperCase(algorithm);
        String oidAlgorithm = algorithm;

        if (oids.containsKey(algKey))
        {
            oidAlgorithm = ((ASN1ObjectIdentifier)oids.get(algKey)).getId();
        }

        // BEGIN android-removed
        // if (kdf != null)
        // {
        //     if (!algorithms.containsKey(oidAlgorithm))
        //     {
        //         throw new NoSuchAlgorithmException("unknown algorithm encountered: " + algorithm);
        //     }
        //     
        //     int    keySize = ((Integer)algorithms.get(oidAlgorithm)).intValue();
        //
        //     DHKDFParameters params = new DHKDFParameters(new ASN1ObjectIdentifier(oidAlgorithm), keySize, secret);
        //
        //     byte[] keyBytes = new byte[keySize / 8];
        //     kdf.init(params);
        //     kdf.generateBytes(keyBytes, 0, keyBytes.length);
        //     secret = keyBytes;
        // }
        // else
        // END android-removed
        {
            if (algorithms.containsKey(oidAlgorithm))
            {
                Integer length = (Integer)algorithms.get(oidAlgorithm);

                byte[] key = new byte[length.intValue() / 8];

                System.arraycopy(secret, 0, key, 0, key.length);

                secret = key;
            }
        }

        if (des.containsKey(oidAlgorithm))
        {
            DESParameters.setOddParity(secret);
        }

        return new SecretKeySpec(secret, algorithm);
    }

=======
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
    protected void engineInit(
        Key                     key,
        AlgorithmParameterSpec  params,
        SecureRandom            random) 
        throws InvalidKeyException, InvalidAlgorithmParameterException
    {
        if (params != null && !(params instanceof MQVParameterSpec || params instanceof UserKeyingMaterialSpec))
        {
            throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
        }

        initFromKey(key, params);
    }

    protected void engineInit(
        Key             key,
        SecureRandom    random) 
        throws InvalidKeyException
    {
        initFromKey(key, null);
    }

    private void initFromKey(Key key, AlgorithmParameterSpec parameterSpec)
        throws InvalidKeyException
    {
<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
        // BEGIN android-removed
        // if (agreement instanceof ECMQVBasicAgreement)
        // {
        //     if (!(key instanceof MQVPrivateKey))
        //     {
        //         throw new InvalidKeyException(kaAlgorithm + " key agreement requires "
        //             + getSimpleName(MQVPrivateKey.class) + " for initialisation");
        //     }
        //
        //     MQVPrivateKey mqvPrivKey = (MQVPrivateKey)key;
        //     ECPrivateKeyParameters staticPrivKey = (ECPrivateKeyParameters)
        //         ECUtil.generatePrivateKeyParameter(mqvPrivKey.getStaticPrivateKey());
        //     ECPrivateKeyParameters ephemPrivKey = (ECPrivateKeyParameters)
        //         ECUtil.generatePrivateKeyParameter(mqvPrivKey.getEphemeralPrivateKey());
        //
        //     ECPublicKeyParameters ephemPubKey = null;
        //     if (mqvPrivKey.getEphemeralPublicKey() != null)
        //     {
        //         ephemPubKey = (ECPublicKeyParameters)
        //             ECUtil.generatePublicKeyParameter(mqvPrivKey.getEphemeralPublicKey());
        //     }
        //
        //     MQVPrivateParameters localParams = new MQVPrivateParameters(staticPrivKey, ephemPrivKey, ephemPubKey);
        //     this.parameters = staticPrivKey.getParameters();
        //
        //     // TODO Validate that all the keys are using the same parameters?
        //
        //     agreement.init(localParams);
        // }
        // else
        // END android-removed
=======
        if (agreement instanceof ECMQVBasicAgreement)
        {
            mqvParameters = null;
            if (!(key instanceof MQVPrivateKey) && !(parameterSpec instanceof MQVParameterSpec))
            {
                throw new InvalidKeyException(kaAlgorithm + " key agreement requires "
                    + getSimpleName(MQVParameterSpec.class) + " for initialisation");
            }

            ECPrivateKeyParameters staticPrivKey;
            ECPrivateKeyParameters ephemPrivKey;
            ECPublicKeyParameters ephemPubKey;
            if (key instanceof MQVPrivateKey)
            {
                MQVPrivateKey mqvPrivKey = (MQVPrivateKey)key;
                staticPrivKey = (ECPrivateKeyParameters)
                    ECUtil.generatePrivateKeyParameter(mqvPrivKey.getStaticPrivateKey());
                ephemPrivKey = (ECPrivateKeyParameters)
                    ECUtil.generatePrivateKeyParameter(mqvPrivKey.getEphemeralPrivateKey());

                ephemPubKey = null;
                if (mqvPrivKey.getEphemeralPublicKey() != null)
                {
                    ephemPubKey = (ECPublicKeyParameters)
                        ECUtil.generatePublicKeyParameter(mqvPrivKey.getEphemeralPublicKey());
                }
            }
            else
            {
                MQVParameterSpec mqvParameterSpec = (MQVParameterSpec)parameterSpec;

                staticPrivKey = (ECPrivateKeyParameters)
                    ECUtil.generatePrivateKeyParameter((PrivateKey)key);
                ephemPrivKey = (ECPrivateKeyParameters)
                    ECUtil.generatePrivateKeyParameter(mqvParameterSpec.getEphemeralPrivateKey());

                ephemPubKey = null;
                if (mqvParameterSpec.getEphemeralPublicKey() != null)
                {
                    ephemPubKey = (ECPublicKeyParameters)
                        ECUtil.generatePublicKeyParameter(mqvParameterSpec.getEphemeralPublicKey());
                }
                mqvParameters = mqvParameterSpec;
                ukmParameters = mqvParameterSpec.getUserKeyingMaterial();
            }

            MQVPrivateParameters localParams = new MQVPrivateParameters(staticPrivKey, ephemPrivKey, ephemPubKey);
            this.parameters = staticPrivKey.getParameters();

            // TODO Validate that all the keys are using the same parameters?

            agreement.init(localParams);
        }
        else
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
        {
            if (!(key instanceof PrivateKey))
            {
                throw new InvalidKeyException(kaAlgorithm + " key agreement requires "
                    + getSimpleName(ECPrivateKey.class) + " for initialisation");
            }

            ECPrivateKeyParameters privKey = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter((PrivateKey)key);
            this.parameters = privKey.getParameters();
            ukmParameters = (parameterSpec instanceof UserKeyingMaterialSpec) ? ((UserKeyingMaterialSpec)parameterSpec).getUserKeyingMaterial() : null;
            agreement.init(privKey);
        }
    }

    private static String getSimpleName(Class clazz)
    {
        String fullName = clazz.getName();

        return fullName.substring(fullName.lastIndexOf('.') + 1);
    }

    public static class DH
        extends KeyAgreementSpi
    {
        public DH()
        {
            super("ECDH", new ECDHBasicAgreement(), null);
        }
    }

<<<<<<< HEAD   (3e75bd Merge "Restoring the contents of aosp after")
    // BEGIN android-removed
    // public static class DHC
    //     extends KeyAgreementSpi
    // {
    //     public DHC()
    //     {
    //         super("ECDHC", new ECDHCBasicAgreement(), null);
    //     }
    // }
    //
    // public static class MQV
    //     extends KeyAgreementSpi
    // {
    //     public MQV()
    //     {
    //         super("ECMQV", new ECMQVBasicAgreement(), null);
    //     }
    // }
    //
    // public static class DHwithSHA1KDF
    //     extends KeyAgreementSpi
    // {
    //     public DHwithSHA1KDF()
    //     {
    //         super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
    //     }
    // }
    //
    // public static class MQVwithSHA1KDF
    //     extends KeyAgreementSpi
    // {
    //     public MQVwithSHA1KDF()
    //     {
    //         super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
    //     }
    // }
    // END android-removed
=======
    public static class DHC
        extends KeyAgreementSpi
    {
        public DHC()
        {
            super("ECDHC", new ECDHCBasicAgreement(), null);
        }
    }

    public static class MQV
        extends KeyAgreementSpi
    {
        public MQV()
        {
            super("ECMQV", new ECMQVBasicAgreement(), null);
        }
    }

    public static class DHwithSHA1KDF
        extends KeyAgreementSpi
    {
        public DHwithSHA1KDF()
        {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA1KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public DHwithSHA1KDFAndSharedInfo()
        {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class CDHwithSHA1KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public CDHwithSHA1KDFAndSharedInfo()
        {
            super("ECCDHwithSHA1KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA224KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public DHwithSHA224KDFAndSharedInfo()
        {
            super("ECDHwithSHA224KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class CDHwithSHA224KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public CDHwithSHA224KDFAndSharedInfo()
        {
            super("ECCDHwithSHA224KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class DHwithSHA256KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public DHwithSHA256KDFAndSharedInfo()
        {
            super("ECDHwithSHA256KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class CDHwithSHA256KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public CDHwithSHA256KDFAndSharedInfo()
        {
            super("ECCDHwithSHA256KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class DHwithSHA384KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public DHwithSHA384KDFAndSharedInfo()
        {
            super("ECDHwithSHA384KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class CDHwithSHA384KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public CDHwithSHA384KDFAndSharedInfo()
        {
            super("ECCDHwithSHA384KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class DHwithSHA512KDFAndSharedInfo
         extends KeyAgreementSpi
     {
         public DHwithSHA512KDFAndSharedInfo()
         {
             super("ECDHwithSHA512KDF", new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
         }
     }

     public static class CDHwithSHA512KDFAndSharedInfo
         extends KeyAgreementSpi
     {
         public CDHwithSHA512KDFAndSharedInfo()
         {
             super("ECCDHwithSHA512KDF", new ECDHCBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
         }
     }

    public static class MQVwithSHA1KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public MQVwithSHA1KDFAndSharedInfo()
        {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()));
        }
    }

    public static class MQVwithSHA224KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public MQVwithSHA224KDFAndSharedInfo()
        {
            super("ECMQVwithSHA224KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA224Digest()));
        }
    }

    public static class MQVwithSHA256KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public MQVwithSHA256KDFAndSharedInfo()
        {
            super("ECMQVwithSHA256KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA256Digest()));
        }
    }

    public static class MQVwithSHA384KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public MQVwithSHA384KDFAndSharedInfo()
        {
            super("ECMQVwithSHA384KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA384Digest()));
        }
    }

    public static class MQVwithSHA512KDFAndSharedInfo
        extends KeyAgreementSpi
    {
        public MQVwithSHA512KDFAndSharedInfo()
        {
            super("ECMQVwithSHA512KDF", new ECMQVBasicAgreement(), new KDF2BytesGenerator(new SHA512Digest()));
        }
    }

    public static class DHwithSHA1CKDF
        extends KeyAgreementSpi
    {
        public DHwithSHA1CKDF()
        {
            super("ECDHwithSHA1CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA1Digest()));
        }
    }

    public static class DHwithSHA256CKDF
        extends KeyAgreementSpi
    {
        public DHwithSHA256CKDF()
        {
            super("ECDHwithSHA256CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA256Digest()));
        }
    }

    public static class DHwithSHA384CKDF
        extends KeyAgreementSpi
    {
        public DHwithSHA384CKDF()
        {
            super("ECDHwithSHA384CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA384Digest()));
        }
    }

    public static class DHwithSHA512CKDF
        extends KeyAgreementSpi
    {
        public DHwithSHA512CKDF()
        {
            super("ECDHwithSHA512CKDF", new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(new SHA512Digest()));
        }
    }

    public static class MQVwithSHA1CKDF
        extends KeyAgreementSpi
    {
        public MQVwithSHA1CKDF()
        {
            super("ECMQVwithSHA1CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA1Digest()));
        }
    }

    public static class MQVwithSHA224CKDF
        extends KeyAgreementSpi
    {
        public MQVwithSHA224CKDF()
        {
            super("ECMQVwithSHA224CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA224Digest()));
        }
    }

    public static class MQVwithSHA256CKDF
        extends KeyAgreementSpi
    {
        public MQVwithSHA256CKDF()
        {
            super("ECMQVwithSHA256CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA256Digest()));
        }
    }

    public static class MQVwithSHA384CKDF
        extends KeyAgreementSpi
    {
        public MQVwithSHA384CKDF()
        {
            super("ECMQVwithSHA384CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA384Digest()));
        }
    }

    public static class MQVwithSHA512CKDF
        extends KeyAgreementSpi
    {
        public MQVwithSHA512CKDF()
        {
            super("ECMQVwithSHA512CKDF", new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(new SHA512Digest()));
        }
    }
>>>>>>> BRANCH (119751 bouncycastle: Android tree with upstream code for version 1.)
}
