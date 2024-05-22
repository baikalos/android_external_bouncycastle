package org.bouncycastle.asn1;

/**
 * DER T61String (also the teletex string), try not to use this if you don't need to. The standard support the encoding for
 * this has been withdrawn.
 */
public class DERT61String
    extends ASN1T61String
{
    /**
     * Basic constructor - with string 8 bit assumed.
     *
     * @param string the string to be wrapped.
     */
    public DERT61String(String string)
    {
        super(string);
    }

    /**
     * Basic constructor - string encoded as a sequence of bytes.
     *
     * @param string the byte encoding of the string to be wrapped.
     */
    public DERT61String(byte[] string)
    {
        this(string, true);
    }

    DERT61String(byte[] contents, boolean clone)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        this.string = Strings.toByteArray(string);
    }

    /**
     * Decode the encoded string and return it, 8 bit encoding assumed.
     * @return the decoded String
     */
    public String getString()
    {
        return Strings.fromByteArray(string);
    }

    public String toString()
    {
        return getString();
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
        out.writeEncoded(withTag, BERTags.T61_STRING, string);
    }

    /**
     * Return the encoded string as a byte array.
     * @return the actual bytes making up the encoded body of the T61 string.
     */
    public byte[] getOctets()
    {
        return Arrays.clone(string);
    }

    boolean asn1Equals(
        ASN1Primitive o)
    {
        if (!(o instanceof DERT61String))
        {
            return false;
        }

        return Arrays.areEqual(string, ((DERT61String)o).string);
    }
    
    public int hashCode()
    {
        return Arrays.hashCode(string);
=======
        super(contents, clone);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
}
