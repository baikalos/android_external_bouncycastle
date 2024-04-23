package org.bouncycastle.asn1;

public class DERVideotexString
    extends ASN1VideotexString
{
    public DERVideotexString(byte[] octets)
    {
        this(octets, true);
    }

    DERVideotexString(byte[] contents, boolean clone)
    {
<<<<<<< HEAD
        ASN1Primitive o = obj.getObject();

        if (explicit || o instanceof DERVideotexString)
        {
            return getInstance(o);
        }
        else
        {
            return new DERVideotexString(ASN1OctetString.getInstance(o).getOctets());
        }
    }

    /**
     * basic constructor - with bytes.
     * @param string the byte encoding of the characters making up the string.
     */
    public DERVideotexString(
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
        out.writeEncoded(withTag, BERTags.VIDEOTEX_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
        ASN1Primitive o)
    {
        if (!(o instanceof DERVideotexString))
        {
            return false;
        }

        DERVideotexString  s = (DERVideotexString)o;

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
