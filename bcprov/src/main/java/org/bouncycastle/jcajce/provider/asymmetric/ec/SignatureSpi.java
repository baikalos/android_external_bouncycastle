package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.NullDigest;
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
// BEGIN android-added
import org.bouncycastle.crypto.digests.AndroidDigestFactory;
// END android-added
// BEGIN android-removed
// import org.bouncycastle.crypto.digests.RIPEMD160Digest;
// import org.bouncycastle.crypto.digests.SHA1Digest;
// import org.bouncycastle.crypto.digests.SHA224Digest;
// import org.bouncycastle.crypto.digests.SHA256Digest;
// import org.bouncycastle.crypto.digests.SHA384Digest;
// import org.bouncycastle.crypto.digests.SHA512Digest;
// END android-removed
=======
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.ECDSASigner;
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
// BEGIN android-removed
// import org.bouncycastle.crypto.signers.ECNRSigner;
// import org.bouncycastle.crypto.signers.HMacDSAKCalculator;
// END android-removed
=======
import org.bouncycastle.crypto.signers.ECNRSigner;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;
import org.bouncycastle.crypto.util.DigestFactory;
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
import org.bouncycastle.jcajce.provider.asymmetric.util.DSABase;
import org.bouncycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.util.Arrays;

public class SignatureSpi
    extends DSABase
{
    SignatureSpi(Digest digest, DSA signer, DSAEncoder encoder)
    {
        super(digest, signer, encoder);
    }

    protected void engineInitVerify(PublicKey publicKey)
        throws InvalidKeyException
    {
        CipherParameters param = ECUtils.generatePublicKeyParameter(publicKey);

        digest.reset();
        signer.init(false, param);
    }

    protected void engineInitSign(
        PrivateKey privateKey)
        throws InvalidKeyException
    {
        CipherParameters param = ECUtil.generatePrivateKeyParameter(privateKey);

        digest.reset();

        if (appRandom != null)
        {
            signer.init(true, new ParametersWithRandom(param, appRandom));
        }
        else
        {
            signer.init(true, param);
        }
    }

    static public class ecDSA
        extends SignatureSpi
    {
        public ecDSA()
        {
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
            // BEGIN android-changed
            super(AndroidDigestFactory.getSHA1(), new ECDSASigner(), new StdDSAEncoder());
            // END android-changed
=======
            super(DigestFactory.createSHA1(), new ECDSASigner(), new StdDSAEncoder());
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
        }
    }

<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
    // BEGIN android-removed
    // static public class ecDetDSA
    //     extends SignatureSpi
    // {
    //     public ecDetDSA()
    //     {
    //         super(new SHA1Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA1Digest())), new StdDSAEncoder());
    //     }
    // }
    // END android-removed
=======
    static public class ecDetDSA
        extends SignatureSpi
    {
        public ecDetDSA()
        {
            super(DigestFactory.createSHA1(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA1())), new StdDSAEncoder());
        }
    }
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)

    static public class ecDSAnone
        extends SignatureSpi
    {
        public ecDSAnone()
        {
            super(new NullDigest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    static public class ecDSA224
        extends SignatureSpi
    {
        public ecDSA224()
        {
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
            // BEGIN android-changed
            super(AndroidDigestFactory.getSHA224(), new ECDSASigner(), new StdDSAEncoder());
            // END android-changed
=======
            super(DigestFactory.createSHA224(), new ECDSASigner(), new StdDSAEncoder());
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
        }
    }

<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
    // BEGIN android-removed
    // static public class ecDetDSA224
    //     extends SignatureSpi
    // {
    //     public ecDetDSA224()
    //     {
    //         super(new SHA224Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA224Digest())), new StdDSAEncoder());
    //     }
    // }
    // END android-removed
=======
    static public class ecDetDSA224
        extends SignatureSpi
    {
        public ecDetDSA224()
        {
            super(DigestFactory.createSHA224(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA224())), new StdDSAEncoder());
        }
    }
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)

    static public class ecDSA256
        extends SignatureSpi
    {
        public ecDSA256()
        {
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
            // BEGIN android-changed
            super(AndroidDigestFactory.getSHA256(), new ECDSASigner(), new StdDSAEncoder());
            // END android-changed
=======
            super(DigestFactory.createSHA256(), new ECDSASigner(), new StdDSAEncoder());
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
        }
    }

<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
    // BEGIN android-removed
    // static public class ecDetDSA256
    //     extends SignatureSpi
    // {
    //     public ecDetDSA256()
    //     {
    //         super(new SHA256Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA256Digest())), new StdDSAEncoder());
    //     }
    // }
    // END android-removed
=======
    static public class ecDetDSA256
        extends SignatureSpi
    {
        public ecDetDSA256()
        {
            super(DigestFactory.createSHA256(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA256())), new StdDSAEncoder());
        }
    }
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)

    static public class ecDSA384
        extends SignatureSpi
    {
        public ecDSA384()
        {
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
            // BEGIN android-changed
            super(AndroidDigestFactory.getSHA384(), new ECDSASigner(), new StdDSAEncoder());
            // END android-changed
=======
            super(DigestFactory.createSHA384(), new ECDSASigner(), new StdDSAEncoder());
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
        }
    }

<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
    // BEGIN android-removed
    // static public class ecDetDSA384
    //     extends SignatureSpi
    // {
    //     public ecDetDSA384()
    //     {
    //         super(new SHA384Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA384Digest())), new StdDSAEncoder());
    //     }
    // }
    // END android-removed
=======
    static public class ecDetDSA384
        extends SignatureSpi
    {
        public ecDetDSA384()
        {
            super(DigestFactory.createSHA384(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA384())), new StdDSAEncoder());
        }
    }
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)

    static public class ecDSA512
        extends SignatureSpi
    {
        public ecDSA512()
        {
<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
            // BEGIN android-changed
            super(AndroidDigestFactory.getSHA512(), new ECDSASigner(), new StdDSAEncoder());
            // END android-changed
=======
            super(DigestFactory.createSHA512(), new ECDSASigner(), new StdDSAEncoder());
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
        }
    }

<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
    // BEGIN android-removed
    // static public class ecDetDSA512
    //     extends SignatureSpi
    // {
    //     public ecDetDSA512()
    //     {
    //         super(new SHA512Digest(), new ECDSASigner(new HMacDSAKCalculator(new SHA512Digest())), new StdDSAEncoder());
    //     }
    // }
    //
    // static public class ecDSARipeMD160
    //     extends SignatureSpi
    // {
    //     public ecDSARipeMD160()
    //     {
    //         super(new RIPEMD160Digest(), new ECDSASigner(), new StdDSAEncoder());
    //     }
    // }
    //
    // static public class ecNR
    //     extends SignatureSpi
    // {
    //     public ecNR()
    //     {
    //         super(new SHA1Digest(), new ECNRSigner(), new StdDSAEncoder());
    //     }
    // }
    //
    // static public class ecNR224
    //     extends SignatureSpi
    // {
    //     public ecNR224()
    //     {
    //         super(new SHA224Digest(), new ECNRSigner(), new StdDSAEncoder());
    //     }
    // }
    //
    // static public class ecNR256
    //     extends SignatureSpi
    // {
    //     public ecNR256()
    //     {
    //         super(new SHA256Digest(), new ECNRSigner(), new StdDSAEncoder());
    //     }
    // }
    //
    // static public class ecNR384
    //     extends SignatureSpi
    // {
    //     public ecNR384()
    //     {
    //         super(new SHA384Digest(), new ECNRSigner(), new StdDSAEncoder());
    //     }
    // }
    //
    // static public class ecNR512
    //     extends SignatureSpi
    // {
    //     public ecNR512()
    //     {
    //         super(new SHA512Digest(), new ECNRSigner(), new StdDSAEncoder());
    //     }
    // }
    //
    // static public class ecCVCDSA
    //     extends SignatureSpi
    // {
    //     public ecCVCDSA()
    //     {
    //         super(new SHA1Digest(), new ECDSASigner(), new PlainDSAEncoder());
    //     }
    // }
    //
    // static public class ecCVCDSA224
    //     extends SignatureSpi
    // {
    //     public ecCVCDSA224()
    //     {
    //         super(new SHA224Digest(), new ECDSASigner(), new PlainDSAEncoder());
    //     }
    // }
    //
    // static public class ecCVCDSA256
    //     extends SignatureSpi
    // {
    //     public ecCVCDSA256()
    //     {
    //         super(new SHA256Digest(), new ECDSASigner(), new PlainDSAEncoder());
    //     }
    // }
    //
    // static public class ecCVCDSA384
    //     extends SignatureSpi
    // {
    //     public ecCVCDSA384()
    //     {
    //         super(new SHA384Digest(), new ECDSASigner(), new PlainDSAEncoder());
    //     }
    // }
    //
    // static public class ecCVCDSA512
    //     extends SignatureSpi
    // {
    //     public ecCVCDSA512()
    //     {
    //         super(new SHA512Digest(), new ECDSASigner(), new PlainDSAEncoder());
    //     }
    // }
    //
    // static public class ecPlainDSARP160
    //     extends SignatureSpi
    // {
    //     public ecPlainDSARP160()
    //     {
    //         super(new RIPEMD160Digest(), new ECDSASigner(), new PlainDSAEncoder());
    //     }
    // }
    // END android-removed
=======
    static public class ecDetDSA512
        extends SignatureSpi
    {
        public ecDetDSA512()
        {
            super(DigestFactory.createSHA512(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA512())), new StdDSAEncoder());
        }
    }

    static public class ecDSASha3_224
        extends SignatureSpi
    {
        public ecDSASha3_224()
        {
            super(DigestFactory.createSHA3_224(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    static public class ecDetDSASha3_224
        extends SignatureSpi
    {
        public ecDetDSASha3_224()
        {
            super(DigestFactory.createSHA3_224(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_224())), new StdDSAEncoder());
        }
    }

    static public class ecDSASha3_256
        extends SignatureSpi
    {
        public ecDSASha3_256()
        {
            super(DigestFactory.createSHA3_256(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    static public class ecDetDSASha3_256
        extends SignatureSpi
    {
        public ecDetDSASha3_256()
        {
            super(DigestFactory.createSHA3_256(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_256())), new StdDSAEncoder());
        }
    }

    static public class ecDSASha3_384
        extends SignatureSpi
    {
        public ecDSASha3_384()
        {
            super(DigestFactory.createSHA3_384(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    static public class ecDetDSASha3_384
        extends SignatureSpi
    {
        public ecDetDSASha3_384()
        {
            super(DigestFactory.createSHA3_384(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_384())), new StdDSAEncoder());
        }
    }

    static public class ecDSASha3_512
        extends SignatureSpi
    {
        public ecDSASha3_512()
        {
            super(DigestFactory.createSHA3_512(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    static public class ecDetDSASha3_512
        extends SignatureSpi
    {
        public ecDetDSASha3_512()
        {
            super(DigestFactory.createSHA3_512(), new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_512())), new StdDSAEncoder());
        }
    }

    static public class ecDSARipeMD160
        extends SignatureSpi
    {
        public ecDSARipeMD160()
        {
            super(new RIPEMD160Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    static public class ecNR
        extends SignatureSpi
    {
        public ecNR()
        {
            super(DigestFactory.createSHA1(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    static public class ecNR224
        extends SignatureSpi
    {
        public ecNR224()
        {
            super(DigestFactory.createSHA224(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    static public class ecNR256
        extends SignatureSpi
    {
        public ecNR256()
        {
            super(DigestFactory.createSHA256(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    static public class ecNR384
        extends SignatureSpi
    {
        public ecNR384()
        {
            super(DigestFactory.createSHA384(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    static public class ecNR512
        extends SignatureSpi
    {
        public ecNR512()
        {
            super(DigestFactory.createSHA512(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    static public class ecCVCDSA
        extends SignatureSpi
    {
        public ecCVCDSA()
        {
            super(DigestFactory.createSHA1(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    static public class ecCVCDSA224
        extends SignatureSpi
    {
        public ecCVCDSA224()
        {
            super(DigestFactory.createSHA224(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    static public class ecCVCDSA256
        extends SignatureSpi
    {
        public ecCVCDSA256()
        {
            super(DigestFactory.createSHA256(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    static public class ecCVCDSA384
        extends SignatureSpi
    {
        public ecCVCDSA384()
        {
            super(DigestFactory.createSHA384(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    static public class ecCVCDSA512
        extends SignatureSpi
    {
        public ecCVCDSA512()
        {
            super(DigestFactory.createSHA512(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }

    static public class ecPlainDSARP160
        extends SignatureSpi
    {
        public ecPlainDSARP160()
        {
            super(new RIPEMD160Digest(), new ECDSASigner(), new PlainDSAEncoder());
        }
    }
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)

    private static class StdDSAEncoder
        implements DSAEncoder
    {
        public byte[] encode(
            BigInteger r,
            BigInteger s)
            throws IOException
        {
            ASN1EncodableVector v = new ASN1EncodableVector();

            v.add(new ASN1Integer(r));
            v.add(new ASN1Integer(s));

            return new DERSequence(v).getEncoded(ASN1Encoding.DER);
        }

        public BigInteger[] decode(
            byte[] encoding)
            throws IOException
        {
            ASN1Sequence s = (ASN1Sequence)ASN1Primitive.fromByteArray(encoding);
            if (s.size() != 2)
            {
                throw new IOException("malformed signature");
            }
            if (!Arrays.areEqual(encoding, s.getEncoded(ASN1Encoding.DER)))
            {
                throw new IOException("malformed signature");
            }

            BigInteger[] sig = new BigInteger[2];

            sig[0] = ASN1Integer.getInstance(s.getObjectAt(0)).getValue();
            sig[1] = ASN1Integer.getInstance(s.getObjectAt(1)).getValue();

            return sig;
        }
    }

    // BEGIN android-removed
    // private static class PlainDSAEncoder
    //     implements DSAEncoder
    // {
    //     public byte[] encode(
    //         BigInteger r,
    //         BigInteger s)
    //         throws IOException
    //     {
    //         byte[] first = makeUnsigned(r);
    //         byte[] second = makeUnsigned(s);
    //         byte[] res;
    //
    //         if (first.length > second.length)
    //         {
    //             res = new byte[first.length * 2];
    //         }
    //         else
    //         {
    //             res = new byte[second.length * 2];
    //         }
    //
    //         System.arraycopy(first, 0, res, res.length / 2 - first.length, first.length);
    //         System.arraycopy(second, 0, res, res.length - second.length, second.length);
    //
    //         return res;
    //     }
    //
    //
    //     private byte[] makeUnsigned(BigInteger val)
    //     {
    //         byte[] res = val.toByteArray();
    //
    //         if (res[0] == 0)
    //         {
    //             byte[] tmp = new byte[res.length - 1];
    //
    //             System.arraycopy(res, 1, tmp, 0, tmp.length);
    //
    //             return tmp;
    //         }
    //
    //         return res;
    //     }
    //
    //     public BigInteger[] decode(
    //         byte[] encoding)
    //         throws IOException
    //     {
    //         BigInteger[] sig = new BigInteger[2];
    //
    //         byte[] first = new byte[encoding.length / 2];
    //         byte[] second = new byte[encoding.length / 2];
    //
    //         System.arraycopy(encoding, 0, first, 0, first.length);
    //         System.arraycopy(encoding, first.length, second, 0, second.length);
    //
    //         sig[0] = new BigInteger(1, first);
    //         sig[1] = new BigInteger(1, second);
    //
    //         return sig;
    //     }
    // }
    // END android-removed
}
