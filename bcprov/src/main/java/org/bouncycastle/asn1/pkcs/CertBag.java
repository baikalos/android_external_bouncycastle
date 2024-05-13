package org.bouncycastle.asn1.pkcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class CertBag
    extends ASN1Object
{
    private ASN1ObjectIdentifier certId;
    private ASN1Encodable certValue;

    private CertBag(
        ASN1Sequence    seq)
    {
        this.certId = ASN1ObjectIdentifier.getInstance(seq.getObjectAt(0));
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        this.certValue = ASN1TaggedObject.getInstance(seq.getObjectAt(1)).getObject();
=======
        this.certValue = ASN1TaggedObject.getInstance(seq.getObjectAt(1)).getExplicitBaseObject();
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    public static CertBag getInstance(Object o)
    {
        if (o instanceof CertBag)
        {
            return (CertBag)o;
        }
        else if (o != null)
        {
            return new CertBag(ASN1Sequence.getInstance(o));
        }

        return null;
    }

    public CertBag(
        ASN1ObjectIdentifier certId,
        ASN1Encodable        certValue)
    {
        this.certId = certId;
        this.certValue = certValue;
    }

    public ASN1ObjectIdentifier getCertId()
    {
        return certId;
    }

    public ASN1Encodable getCertValue()
    {
        return certValue;
    }

    public ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector(2);

        v.add(certId);
        v.add(new DERTaggedObject(0, certValue));

        return new DERSequence(v);
    }
}
