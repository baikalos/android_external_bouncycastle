/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.internal.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;

<<<<<<< HEAD:repackaged_platform/bcprov/src/main/java/com/android/internal/org/bouncycastle/jce/provider/JCEECPrivateKey.java
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.DERNull;
// Android-removed: Unsupported algorithms
// import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
// import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import com.android.internal.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.android.internal.org.bouncycastle.asn1.sec.ECPrivateKeyStructure;
import com.android.internal.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.internal.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.internal.org.bouncycastle.asn1.x9.X962Parameters;
import com.android.internal.org.bouncycastle.asn1.x9.X9ECParameters;
import com.android.internal.org.bouncycastle.asn1.x9.X9ECPoint;
import com.android.internal.org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.android.internal.org.bouncycastle.crypto.params.ECDomainParameters;
import com.android.internal.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import com.android.internal.org.bouncycastle.jce.interfaces.ECPointEncoder;
import com.android.internal.org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import com.android.internal.org.bouncycastle.jce.spec.ECNamedCurveSpec;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.util.Strings;
=======
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.ua.DSTU4145BinaryField;
import org.bouncycastle.asn1.ua.DSTU4145ECBinary;
import org.bouncycastle.asn1.ua.DSTU4145NamedCurves;
import org.bouncycastle.asn1.ua.DSTU4145Params;
import org.bouncycastle.asn1.ua.DSTU4145PointEncoder;
import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/jcajce/provider/asymmetric/dstu/BCDSTU4145PrivateKey.java

/**
 * @hide This class is not part of the Android public SDK API
 */
public class JCEECPrivateKey
    implements ECPrivateKey, com.android.internal.org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder
{
    private String          algorithm = "EC";
    private BigInteger      d;
    private ECParameterSpec ecSpec;
    private boolean         withCompression;

    private DERBitString publicKey;

<<<<<<< HEAD:repackaged_platform/bcprov/src/main/java/com/android/internal/org/bouncycastle/jce/provider/JCEECPrivateKey.java
    private PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
=======
    private transient BigInteger d;
    private transient ECParameterSpec ecSpec;
    private transient ASN1BitString publicKey;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/jcajce/provider/asymmetric/dstu/BCDSTU4145PrivateKey.java

    protected JCEECPrivateKey()
    {
    }

    public JCEECPrivateKey(
        ECPrivateKey    key)
    {
        this.d = key.getS();
        this.algorithm = key.getAlgorithm();
        this.ecSpec = key.getParams();
    }

    public JCEECPrivateKey(
        String              algorithm,
        com.android.internal.org.bouncycastle.jce.spec.ECPrivateKeySpec     spec)
    {
        this.algorithm = algorithm;
        this.d = spec.getD();

        if (spec.getParams() != null) // can be null if implicitlyCA
        {
            ECCurve curve = spec.getParams().getCurve();
            EllipticCurve ellipticCurve;

            ellipticCurve = EC5Util.convertCurve(curve, spec.getParams().getSeed());

            this.ecSpec = EC5Util.convertSpec(ellipticCurve, spec.getParams());
        }
        else
        {
            this.ecSpec = null;
        }
    }


    public JCEECPrivateKey(
        String              algorithm,
        ECPrivateKeySpec    spec)
    {
        this.algorithm = algorithm;
        this.d = spec.getS();
        this.ecSpec = spec.getParams();
    }

    public JCEECPrivateKey(
        String             algorithm,
        JCEECPrivateKey    key)
    {
        this.algorithm = algorithm;
        this.d = key.d;
        this.ecSpec = key.ecSpec;
        this.withCompression = key.withCompression;
        this.attrCarrier = key.attrCarrier;
        this.publicKey = key.publicKey;
    }

    public JCEECPrivateKey(
        String                  algorithm,
        ECPrivateKeyParameters  params,
        JCEECPublicKey          pubKey,
        ECParameterSpec         spec)
    {
        this.algorithm = algorithm;
        this.d = params.getD();

        if (spec == null)
        {
            ECDomainParameters dp = params.getParameters();
            EllipticCurve ellipticCurve = EC5Util.convertCurve(dp.getCurve(), dp.getSeed());

            this.ecSpec = new ECParameterSpec(
                ellipticCurve,
                EC5Util.convertPoint(dp.getG()),
                dp.getN(),
                dp.getH().intValue());
        }
        else
        {
            this.ecSpec = spec;
        }

        publicKey = getPublicKeyDetails(pubKey);
    }

    public JCEECPrivateKey(
        String                  algorithm,
        ECPrivateKeyParameters  params,
        JCEECPublicKey          pubKey,
        com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec         spec)
    {
        this.algorithm = algorithm;
        this.d = params.getD();

        if (spec == null)
        {
            ECDomainParameters dp = params.getParameters();
            EllipticCurve ellipticCurve = EC5Util.convertCurve(dp.getCurve(), dp.getSeed());

            this.ecSpec = new ECParameterSpec(
                ellipticCurve,
                EC5Util.convertPoint(dp.getG()),
                dp.getN(),
                dp.getH().intValue());
        }
        else
        {
            EllipticCurve ellipticCurve = EC5Util.convertCurve(spec.getCurve(), spec.getSeed());
            
            this.ecSpec = new ECParameterSpec(
                ellipticCurve,
                EC5Util.convertPoint(spec.getG()),
                spec.getN(),
                spec.getH().intValue());
        }

        publicKey = getPublicKeyDetails(pubKey);
    }

    public JCEECPrivateKey(
        String                  algorithm,
        ECPrivateKeyParameters  params)
    {
        this.algorithm = algorithm;
        this.d = params.getD();
        this.ecSpec = null;
    }

    JCEECPrivateKey(
        PrivateKeyInfo      info)
        throws IOException
    {
        populateFromPrivKeyInfo(info);
    }

    private void populateFromPrivKeyInfo(PrivateKeyInfo info)
        throws IOException
    {
        X962Parameters params = X962Parameters.getInstance(info.getPrivateKeyAlgorithm().getParameters());

        if (params.isNamedCurve())
        {
            ASN1ObjectIdentifier oid = ASN1ObjectIdentifier.getInstance(params.getParameters());
            X9ECParameters ecP = ECUtil.getNamedCurveByOid(oid);

            // BEGIN Android-removed: Unsupported algorithms
            /*
            if (ecP == null) // GOST Curve
            {
                ECDomainParameters gParam = ECGOST3410NamedCurves.getByOID(oid);
                EllipticCurve ellipticCurve = EC5Util.convertCurve(gParam.getCurve(), gParam.getSeed());

                ecSpec = new ECNamedCurveSpec(
                    ECGOST3410NamedCurves.getName(oid),
                    ellipticCurve,
                    EC5Util.convertPoint(gParam.getG()),
                    gParam.getN(),
                    gParam.getH());
            }
            else
            */
            // END Android-removed: Unsupported algorithms
            {
                EllipticCurve ellipticCurve = EC5Util.convertCurve(ecP.getCurve(), ecP.getSeed());

                ecSpec = new ECNamedCurveSpec(
                    ECUtil.getCurveName(oid),
                    ellipticCurve,
                    EC5Util.convertPoint(ecP.getG()),
                    ecP.getN(),
                    ecP.getH());
            }
        }
        else if (params.isImplicitlyCA())
        {
            ecSpec = null;
        }
        else
        {
            X9ECParameters      ecP = X9ECParameters.getInstance(params.getParameters());
            EllipticCurve       ellipticCurve = EC5Util.convertCurve(ecP.getCurve(), ecP.getSeed());

<<<<<<< HEAD:repackaged_platform/bcprov/src/main/java/com/android/internal/org/bouncycastle/jce/provider/JCEECPrivateKey.java
            this.ecSpec = new ECParameterSpec(
                ellipticCurve,
                EC5Util.convertPoint(ecP.getG()),
                ecP.getN(),
                ecP.getH().intValue());
=======
            if (seq.getObjectAt(0) instanceof ASN1Integer)
            {
                X9ECParameters ecP = X9ECParameters.getInstance(params.getParameters());
                EllipticCurve ellipticCurve = EC5Util.convertCurve(ecP.getCurve(), ecP.getSeed());

                this.ecSpec = new ECParameterSpec(
                    ellipticCurve,
                    EC5Util.convertPoint(ecP.getG()),
                    ecP.getN(),
                    ecP.getH().intValue());
            }
            else
            {
                DSTU4145Params dstuParams = DSTU4145Params.getInstance(seq);
                org.bouncycastle.jce.spec.ECParameterSpec spec;
                if (dstuParams.isNamedCurve())
                {
                    ASN1ObjectIdentifier curveOid = dstuParams.getNamedCurve();
                    ECDomainParameters ecP = DSTU4145NamedCurves.getByOID(curveOid);

                    spec = new ECNamedCurveParameterSpec(curveOid.getId(), ecP.getCurve(), ecP.getG(), ecP.getN(), ecP.getH(), ecP.getSeed());
                }
                else
                {
                    DSTU4145ECBinary binary = dstuParams.getECBinary();
                    byte[] b_bytes = binary.getB();
                    if (info.getPrivateKeyAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le))
                    {
                        reverseBytes(b_bytes);
                    }
                    DSTU4145BinaryField field = binary.getField();
                    ECCurve curve = new ECCurve.F2m(field.getM(), field.getK1(), field.getK2(), field.getK3(), binary.getA(), new BigInteger(1, b_bytes), null, null);
                    byte[] g_bytes = binary.getG();
                    if (info.getPrivateKeyAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le))
                    {
                        reverseBytes(g_bytes);
                    }
                    spec = new org.bouncycastle.jce.spec.ECParameterSpec(curve, DSTU4145PointEncoder.decodePoint(curve, g_bytes), binary.getN());
                }

                EllipticCurve ellipticCurve = EC5Util.convertCurve(spec.getCurve(), spec.getSeed());

                this.ecSpec = new ECParameterSpec(
                    ellipticCurve,
                    EC5Util.convertPoint(spec.getG()),
                    spec.getN(),
                    spec.getH().intValue());
            }
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/jcajce/provider/asymmetric/dstu/BCDSTU4145PrivateKey.java
        }

        ASN1Encodable privKey = info.parsePrivateKey();
        if (privKey instanceof ASN1Integer)
        {
            ASN1Integer          derD = ASN1Integer.getInstance(privKey);

            this.d = derD.getValue();
        }
        else
        {
            ECPrivateKeyStructure ec = new ECPrivateKeyStructure((ASN1Sequence)privKey);

            this.d = ec.getKey();
            this.publicKey = ec.getPublicKey();
        }
    }

    public String getAlgorithm()
    {
        return algorithm;
    }

    /**
     * return the encoding format we produce in getEncoded().
     *
     * @return the string "PKCS#8"
     */
    public String getFormat()
    {
        return "PKCS#8";
    }

    /**
     * Return a PKCS8 representation of the key. The sequence returned
     * represents a full PrivateKeyInfo object.
     *
     * @return a PKCS8 representation of the key.
     */
    public byte[] getEncoded()
    {
        X962Parameters          params;

        if (ecSpec instanceof ECNamedCurveSpec)
        {
            ASN1ObjectIdentifier curveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec)ecSpec).getName());
            if (curveOid == null)  // guess it's the OID
            {
                curveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec)ecSpec).getName());
            }
            params = new X962Parameters(curveOid);
        }
        else if (ecSpec == null)
        {
            params = new X962Parameters(DERNull.INSTANCE);
        }
        else
        {
            ECCurve curve = EC5Util.convertCurve(ecSpec.getCurve());

            X9ECParameters ecP = new X9ECParameters(
                curve,
                new X9ECPoint(EC5Util.convertPoint(curve, ecSpec.getGenerator()), withCompression),
                ecSpec.getOrder(),
                BigInteger.valueOf(ecSpec.getCofactor()),
                ecSpec.getCurve().getSeed());

            params = new X962Parameters(ecP);
        }
        
        PrivateKeyInfo          info;
        ECPrivateKeyStructure keyStructure;

        if (publicKey != null)
        {
            keyStructure = new ECPrivateKeyStructure(this.getS(), publicKey, params);
        }
        else
        {
            keyStructure = new ECPrivateKeyStructure(this.getS(), params);
        }

        try
        {
            // BEGIN Android-removed: Unsupported algorithms
            // if (algorithm.equals("ECGOST3410"))
            // {
            //     info = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, params.toASN1Primitive()), keyStructure.toASN1Primitive());
            // }
            // else
            // END Android-removed: Unsupported algorithms
            {

                info = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, params.toASN1Primitive()), keyStructure.toASN1Primitive());
            }

            return info.getEncoded(ASN1Encoding.DER);
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public ECParameterSpec getParams()
    {
        return ecSpec;
    }

    public com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec getParameters()
    {
        if (ecSpec == null)
        {
            return null;
        }
<<<<<<< HEAD:repackaged_platform/bcprov/src/main/java/com/android/internal/org/bouncycastle/jce/provider/JCEECPrivateKey.java
        
=======

>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/jcajce/provider/asymmetric/dstu/BCDSTU4145PrivateKey.java
        return EC5Util.convertSpec(ecSpec);
    }

    com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec()
    {
        if (ecSpec != null)
        {
            return EC5Util.convertSpec(ecSpec);
        }

        return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public BigInteger getS()
    {
        return d;
    }

    public BigInteger getD()
    {
        return d;
    }
    
    public void setBagAttribute(
        ASN1ObjectIdentifier oid,
        ASN1Encodable        attribute)
    {
        attrCarrier.setBagAttribute(oid, attribute);
    }

    public ASN1Encodable getBagAttribute(
        ASN1ObjectIdentifier oid)
    {
        return attrCarrier.getBagAttribute(oid);
    }

    public Enumeration getBagAttributeKeys()
    {
        return attrCarrier.getBagAttributeKeys();
    }

    public void setPointFormat(String style)
    {
       withCompression = !("UNCOMPRESSED".equalsIgnoreCase(style));
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof JCEECPrivateKey))
        {
            return false;
        }

        JCEECPrivateKey other = (JCEECPrivateKey)o;

        return getD().equals(other.getD()) && (engineGetSpec().equals(other.engineGetSpec()));
    }

    public int hashCode()
    {
        return getD().hashCode() ^ engineGetSpec().hashCode();
    }

    public String toString()
    {
        StringBuffer    buf = new StringBuffer();
        String          nl = Strings.lineSeparator();

        buf.append("EC Private Key").append(nl);
        buf.append("             S: ").append(this.d.toString(16)).append(nl);

        return buf.toString();

    }

<<<<<<< HEAD:repackaged_platform/bcprov/src/main/java/com/android/internal/org/bouncycastle/jce/provider/JCEECPrivateKey.java
    private DERBitString getPublicKeyDetails(JCEECPublicKey   pub)
=======
    private ASN1BitString getPublicKeyDetails(BCDSTU4145PublicKey pub)
>>>>>>> aosp/upstream-master:bcprov/src/main/java/org/bouncycastle/jcajce/provider/asymmetric/dstu/BCDSTU4145PrivateKey.java
    {
        try
        {
            SubjectPublicKeyInfo info = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(pub.getEncoded()));

            return info.getPublicKeyData();
        }
        catch (IOException e)
        {   // should never happen
            return null;
        }
    }

    private void readObject(
        ObjectInputStream in)
        throws IOException, ClassNotFoundException
    {
        byte[] enc = (byte[])in.readObject();

        populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(enc)));

        this.algorithm = (String)in.readObject();
        this.withCompression = in.readBoolean();
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();

        attrCarrier.readObject(in);
    }

    private void writeObject(
        ObjectOutputStream out)
        throws IOException
    {
        out.writeObject(this.getEncoded());
        out.writeObject(algorithm);
        out.writeBoolean(withCompression);

        attrCarrier.writeObject(out);
    }
}
