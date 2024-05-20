package org.bouncycastle.asn1;

import java.io.IOException;

/**
 * A BIT STRING with DER encoding - the first byte contains the count of padding bits included in the byte array's last byte.
 */
public class DERBitString
    extends ASN1BitString
{
    public static DERBitString convert(ASN1BitString bitString)
    {
        return (DERBitString)bitString.toDERObject();
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    /**
     * return a Bit String from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     * @return a DERBitString instance, or null.
     */
    public static DERBitString getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        ASN1Primitive o = obj.getObject();

        if (explicit || o instanceof DERBitString)
        {
            return getInstance(o);
        }
        else
        {
            return fromOctetString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    protected DERBitString(byte data, int padBits)
    {
        super(data, padBits);
    }

    /**
     * @param data the octets making up the bit string.
     * @param padBits the number of extra bits at the end of the string.
     */
    public DERBitString(
        byte[]  data,
        int     padBits)
    {
        super(data, padBits);
    }

    public DERBitString(
        byte[]  data)
=======
    public DERBitString(byte[] data)
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
        this(data, 0);
    }

    public DERBitString(byte data, int padBits)
    {
        super(data, padBits);
    }

    public DERBitString(byte[] data, int padBits)
    {
        super(data, padBits);
    }

    public DERBitString(int value)
    {
        // TODO[asn1] Unify in single allocation of 'contents'
        super(getBytes(value), getPadBits(value));
    }

    public DERBitString(ASN1Encodable obj) throws IOException
    {
        // TODO[asn1] Unify in single allocation of 'contents'
        super(obj.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    DERBitString(byte[] contents, boolean check)
    {
        super(contents, check);
    }

    boolean encodeConstructed()
    {
        return false;
    }

    int encodedLength(boolean withTag)
    {
        return ASN1OutputStream.getLengthOfEncodingDL(withTag, contents.length);
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        int len = data.length;
        if (0 == len
            || 0 == padBits
            || (data[len - 1] == (byte)(data[len - 1] & (0xFF << padBits))))
        {
            out.writeEncoded(withTag, BERTags.BIT_STRING, (byte)padBits, data);
        }
        else
        {
            byte der = (byte)(data[len - 1] & (0xFF << padBits));
            out.writeEncoded(withTag, BERTags.BIT_STRING, (byte)padBits, data, 0, len - 1, der);
        }
    }
=======
        int padBits = contents[0] & 0xFF;
        int length = contents.length;
        int last = length - 1;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    ASN1Primitive toDERObject()
    {
        return this;
    }
=======
        byte lastOctet = contents[last];
        byte lastOctetDER = (byte)(contents[last] & (0xFF << padBits));
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    ASN1Primitive toDLObject()
    {
        return this;
=======
        if (lastOctet == lastOctetDER)
        {
            out.writeEncodingDL(withTag, BERTags.BIT_STRING, contents);
        }
        else
        {
            out.writeEncodingDL(withTag, BERTags.BIT_STRING, contents, 0, last, lastOctetDER);
        }
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    ASN1Primitive toDERObject()
    {
        return this;
    }

    ASN1Primitive toDLObject()
    {
        return this;
    }

    static DERBitString fromOctetString(ASN1OctetString octetString)
    {
        return new DERBitString(octetString.getOctets(), true);
    }
}
