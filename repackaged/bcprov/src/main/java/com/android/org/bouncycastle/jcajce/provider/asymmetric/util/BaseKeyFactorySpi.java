<<<<<<< HEAD:repackaged/bcprov/src/main/java/com/android/org/bouncycastle/jcajce/provider/asymmetric/util/BaseKeyFactorySpi.java
/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.Key;
=======
package org.bouncycastle.pqc.jcajce.provider.util;

import java.security.KeyFactorySpi;
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/pqc/jcajce/provider/util/BaseKeyFactorySpi.java
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
<<<<<<< HEAD:repackaged/bcprov/src/main/java/com/android/org/bouncycastle/jcajce/provider/asymmetric/util/BaseKeyFactorySpi.java

import com.android.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.android.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/**
 * @hide This class is not part of the Android public SDK API
 */
public abstract class BaseKeyFactorySpi
    extends java.security.KeyFactorySpi
    implements AsymmetricKeyInfoConverter
{
    protected PrivateKey engineGeneratePrivate(
        KeySpec keySpec)
=======
import java.util.Set;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public abstract class BaseKeyFactorySpi
    extends KeyFactorySpi
    implements AsymmetricKeyInfoConverter
{
    private final Set<ASN1ObjectIdentifier> keyOids;
    private final ASN1ObjectIdentifier keyOid;

    protected BaseKeyFactorySpi(Set<ASN1ObjectIdentifier> keyOids)
    {
        this.keyOid = null;
        this.keyOids = keyOids;
    }

    protected BaseKeyFactorySpi(ASN1ObjectIdentifier keyOid)
    {
        this.keyOid = keyOid;
        this.keyOids = null;
    }

    public PrivateKey engineGeneratePrivate(KeySpec keySpec)
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/pqc/jcajce/provider/util/BaseKeyFactorySpi.java
        throws InvalidKeySpecException
    {
        if (keySpec instanceof PKCS8EncodedKeySpec)
        {
<<<<<<< HEAD:repackaged/bcprov/src/main/java/com/android/org/bouncycastle/jcajce/provider/asymmetric/util/BaseKeyFactorySpi.java
            try
            {
                return generatePrivate(PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec)keySpec).getEncoded()));
            }
            catch (Exception e)
            {
                throw new InvalidKeySpecException("encoded key spec not recognized: " + e.getMessage());
            }
        }
        else
        {
            throw new InvalidKeySpecException("key spec not recognized");
        }
    }

    protected PublicKey engineGeneratePublic(
        KeySpec keySpec)
=======
            // get the DER-encoded Key according to PKCS#8 from the spec
            byte[] encKey = ((PKCS8EncodedKeySpec)keySpec).getEncoded();

            try
            {
                PrivateKeyInfo keyInfo = PrivateKeyInfo.getInstance(encKey);

                checkAlgorithm(keyInfo.getPrivateKeyAlgorithm().getAlgorithm());

                return generatePrivate(keyInfo);
            }
            catch (Exception e)
            {
                throw new InvalidKeySpecException(e.toString());
            }
        }

        throw new InvalidKeySpecException("Unsupported key specification: "
            + keySpec.getClass() + ".");
    }

    public PublicKey engineGeneratePublic(KeySpec keySpec)
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/pqc/jcajce/provider/util/BaseKeyFactorySpi.java
        throws InvalidKeySpecException
    {
        if (keySpec instanceof X509EncodedKeySpec)
        {
<<<<<<< HEAD:repackaged/bcprov/src/main/java/com/android/org/bouncycastle/jcajce/provider/asymmetric/util/BaseKeyFactorySpi.java
            try
            {
                return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec)keySpec).getEncoded()));
            }
            catch (Exception e)
            {
                throw new InvalidKeySpecException("encoded key spec not recognized: " + e.getMessage());
            }
        }
        else
        {
            throw new InvalidKeySpecException("key spec not recognized");
        }
    }

    protected KeySpec engineGetKeySpec(
        Key key,
        Class spec)
        throws InvalidKeySpecException
    {
        if (spec.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals("PKCS#8"))
        {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        else if (spec.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals("X.509"))
        {
            return new X509EncodedKeySpec(key.getEncoded());
        }

        throw new InvalidKeySpecException("not implemented yet " + key + " " + spec);
=======
            // get the DER-encoded Key according to X.509 from the spec
            byte[] encKey = ((X509EncodedKeySpec)keySpec).getEncoded();

            // decode the SubjectPublicKeyInfo data structure to the pki object
            try
            {
                SubjectPublicKeyInfo keyInfo = SubjectPublicKeyInfo.getInstance(encKey);

                checkAlgorithm(keyInfo.getAlgorithm().getAlgorithm());

                return generatePublic(keyInfo);
            }
            catch (Exception e)
            {
                throw new InvalidKeySpecException(e.toString());
            }
        }

        throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
    }

    private void checkAlgorithm(ASN1ObjectIdentifier algOid)
        throws InvalidKeySpecException
    {
        if (keyOid != null)
        {
            if (!keyOid.equals(algOid))
            {
                throw new InvalidKeySpecException("incorrect algorithm OID for key: " + algOid);
            }
        }
        else if (!keyOids.contains(algOid))
        {
            throw new InvalidKeySpecException("incorrect algorithm OID for key: " + algOid);
        }
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/pqc/jcajce/provider/util/BaseKeyFactorySpi.java
    }
}
