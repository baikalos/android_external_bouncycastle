package org.bouncycastle.asn1;

/**
 * DER VisibleString object encoding ISO 646 (ASCII) character code points 32 to 126.
 * <p>
 * Explicit character set escape sequences are not allowed.
 * </p>
 */
public class DERVisibleString
    extends ASN1VisibleString
{
    /**
     * Basic constructor
     *
     * @param string the string to be carried in the VisibleString object,
     */
    public DERVisibleString(String string)
    {
        super(string);
    }

    DERVisibleString(byte[] contents, boolean clone)
    {
<<<<<<< HEAD
        return Strings.fromByteArray(string);
    }

    public String toString()
    {
        return getString();
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
        out.writeEncoded(withTag, BERTags.VISIBLE_STRING, this.string);
    }

    boolean asn1Equals(
        ASN1Primitive o)
    {
        if (!(o instanceof DERVisibleString))
        {
            return false;
        }

        return Arrays.areEqual(string, ((DERVisibleString)o).string);
    }
    
    public int hashCode()
    {
        return Arrays.hashCode(string);
=======
        super(contents, clone);
>>>>>>> aosp/upstream-master
    }
}
