package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PrimeCertaintyCalculator;

public class KeyPairGeneratorSpi
    extends java.security.KeyPairGenerator
{
    public KeyPairGeneratorSpi(
        String algorithmName)
    {
        super(algorithmName);
    }

    final static BigInteger defaultPublicExponent = BigInteger.valueOf(0x10001);

    RSAKeyGenerationParameters param;
    RSAKeyPairGenerator engine;

    public KeyPairGeneratorSpi()
    {
        super("RSA");

        engine = new RSAKeyPairGenerator();
        param = new RSAKeyGenerationParameters(defaultPublicExponent,
            new SecureRandom(), 2048, PrimeCertaintyCalculator.getDefaultCertainty(2048));
        engine.init(param);
    }

    public void initialize(
        int strength,
        SecureRandom random)
    {
        param = new RSAKeyGenerationParameters(defaultPublicExponent,
<<<<<<< HEAD   (9cea60 Merge "Add OWNERS in external/bouncycastle")
            // BEGIN android-changed
            // Was: random, strength, defaultTests);
            (random != null) ? random : new SecureRandom(), strength, defaultTests);
            // END android-changed
=======
            random, strength, PrimeCertaintyCalculator.getDefaultCertainty(strength));
>>>>>>> BRANCH (1e6eca Merge "bouncycastle: Android tree with upstream code for ver)

        engine.init(param);
    }

    public void initialize(
        AlgorithmParameterSpec params,
        SecureRandom random)
        throws InvalidAlgorithmParameterException
    {
        if (!(params instanceof RSAKeyGenParameterSpec))
        {
            throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
        }
        RSAKeyGenParameterSpec rsaParams = (RSAKeyGenParameterSpec)params;

        param = new RSAKeyGenerationParameters(
            rsaParams.getPublicExponent(),
<<<<<<< HEAD   (9cea60 Merge "Add OWNERS in external/bouncycastle")
            // BEGIN android-changed
            // Was: random, rsaParams.getKeysize(), defaultTests);
            (random != null) ? random : new SecureRandom(), rsaParams.getKeysize(), defaultTests);
            // END android-changed
=======
            random, rsaParams.getKeysize(), PrimeCertaintyCalculator.getDefaultCertainty(2048));
>>>>>>> BRANCH (1e6eca Merge "bouncycastle: Android tree with upstream code for ver)

        engine.init(param);
    }

    public KeyPair generateKeyPair()
    {
        AsymmetricCipherKeyPair pair = engine.generateKeyPair();
        RSAKeyParameters pub = (RSAKeyParameters)pair.getPublic();
        RSAPrivateCrtKeyParameters priv = (RSAPrivateCrtKeyParameters)pair.getPrivate();

        return new KeyPair(new BCRSAPublicKey(pub),
            new BCRSAPrivateCrtKey(priv));
    }
}
