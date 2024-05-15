package org.bouncycastle.jcajce.provider.symmetric.util;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.security.auth.Destroyable;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class BCPBEKey
    implements PBEKey, Destroyable
{
    private final AtomicBoolean hasBeenDestroyed = new AtomicBoolean(false);

    String              algorithm;
    ASN1ObjectIdentifier oid;
    int                 type;
    int                 digest;
    int                 keySize;
    int                 ivSize;

    private final char[] password;
    private final byte[] salt;
    private final int iterationCount;

    private final CipherParameters    param;

    boolean             tryWrong = false;

    /**
     * @param param
     */
    public BCPBEKey(
        String algorithm,
        ASN1ObjectIdentifier oid,
        int type,
        int digest,
        int keySize,
        int ivSize,
        PBEKeySpec pbeKeySpec,
        CipherParameters param)
    {
        this.algorithm = algorithm;
        this.oid = oid;
        this.type = type;
        this.digest = digest;
        this.keySize = keySize;
        this.ivSize = ivSize;
        this.password = pbeKeySpec.getPassword();
        this.iterationCount = pbeKeySpec.getIterationCount();
        this.salt = pbeKeySpec.getSalt();
        this.param = param;
    }

    public BCPBEKey(String algName, CipherParameters param)
    {
        this.algorithm = algName;
        this.param = param;
        this.password = null;
        this.iterationCount = -1;
        this.salt = null;
    }

    public String getAlgorithm()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return algorithm;
=======
        String rv = this.algorithm;

        checkDestroyed(this);

        return rv;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    public String getFormat()
    {
        checkDestroyed(this);

        return "RAW";
    }

    public byte[] getEncoded()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);
=======
        byte[] enc;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

        if (param != null)
        {
            KeyParameter    kParam;
            
            if (param instanceof ParametersWithIV)
            {
                kParam = (KeyParameter)((ParametersWithIV)param).getParameters();
            }
            else
            {
                kParam = (KeyParameter)param;
            }
            
            enc = kParam.getKey();
        }
        else
        {
            if (type == PBE.PKCS12)
            {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
                return PBEParametersGenerator.PKCS12PasswordToBytes(password);
=======
                enc = PBEParametersGenerator.PKCS12PasswordToBytes(password);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
            }
            else if (type == PBE.PKCS5S2_UTF8)
            {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
                return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(password);
=======
                enc = PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(password);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
            }
            else
            {   
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
                return PBEParametersGenerator.PKCS5PasswordToBytes(password);
=======
                enc = PBEParametersGenerator.PKCS5PasswordToBytes(password);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
            }
        }

        checkDestroyed(this);

        return enc;
    }
    
    int getType()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return type;
=======
        int rv = type;

        checkDestroyed(this);

        return rv;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
    
    int getDigest()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return digest;
=======
        int rv = digest;

        checkDestroyed(this);

        return rv;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
    
    int getKeySize()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return keySize;
=======
        int rv = keySize;

        checkDestroyed(this);

        return rv;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
    
    public int getIvSize()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return ivSize;
=======
        int rv = ivSize;

        checkDestroyed(this);

        return rv;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
    
    public CipherParameters getParam()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return param;
=======
        CipherParameters rv = param;

        checkDestroyed(this);

        return rv;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    /* (non-Javadoc)
     * @see javax.crypto.interfaces.PBEKey#getPassword()
     */
    public char[] getPassword()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        if (password == null)
        {
            throw new IllegalStateException("no password available");
        }

        return Arrays.clone(password);
=======
        char[] clone = Arrays.clone(password);

        checkDestroyed(this);

        if (clone == null)
        {
            throw new IllegalStateException("no password available");
        }

        return clone;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    /* (non-Javadoc)
     * @see javax.crypto.interfaces.PBEKey#getSalt()
     */
    public byte[] getSalt()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return Arrays.clone(salt);
=======
        byte[] clone = Arrays.clone(salt);

        checkDestroyed(this);

        return clone;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    /* (non-Javadoc)
     * @see javax.crypto.interfaces.PBEKey#getIterationCount()
     */
    public int getIterationCount()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return iterationCount;
=======
        int rv = iterationCount;

        checkDestroyed(this);

        return rv;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
    
    public ASN1ObjectIdentifier getOID()
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        checkDestroyed(this);

        return oid;
=======
        ASN1ObjectIdentifier rv = oid;

        checkDestroyed(this);

        return rv;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
    
    public void setTryWrongPKCS12Zero(boolean tryWrong)
    {
        this.tryWrong = tryWrong; 
    }
    
    boolean shouldTryWrongPKCS12()
    {
        return tryWrong;
    }

    public void destroy()
    {
        if (!hasBeenDestroyed.getAndSet(true))
        {
            if (password != null)
            {
                Arrays.fill(password, (char)0);
            }
            if (salt != null)
            {
                Arrays.fill(salt, (byte)0);
            }
        }
    }

    public boolean isDestroyed()
    {
        return hasBeenDestroyed.get();
    }

    static void checkDestroyed(Destroyable destroyable)
    {
        if (destroyable.isDestroyed())
        {
            throw new IllegalStateException("key has been destroyed");
        }
    }
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
}
=======
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
