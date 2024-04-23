package org.bouncycastle.asn1;

public class DERGraphicString
    extends ASN1GraphicString
{
    public DERGraphicString(byte[] octets)
    {
        this(octets, true);
    }

    DERGraphicString(byte[] contents, boolean clone)
    {
<<<<<<< HEAD
        ASN1Primitive o = obj.getObject();

        if (explicit || o instanceof DERGraphicString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERGraphicString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    /**
     * basic constructor - with bytes.
     * @param string the byte encoding of the characters making up the string.
     */
    public DERGraphicString(
        byte[]   string)
    {
        this.string = Arrays.clone(string);
    }
    
    public byte[] getOctets()
    {
        return Arrays.clone(string);
    }

    boolean isConstructed()
    {
        return false;
    }

    int encodedLength()
    {
        return 1 + StreamUtil.calculateBodyLength(string.length) + string.length;
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
        out.writeEncoded(withTag, BERTags.GRAPHIC_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
        ASN1Primitive o)
    {
        if (!(o instanceof DERGraphicString))
        {
            return false;
        }

        DERGraphicString  s = (DERGraphicString)o;

        return Arrays.areEqual(string, s.string);
    }

    public String getString()
    {
        return Strings.fromByteArray(string);
=======
        super(contents, clone);
>>>>>>> aosp/upstream-master
    }
}
