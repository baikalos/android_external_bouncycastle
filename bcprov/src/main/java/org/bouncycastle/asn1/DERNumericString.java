package org.bouncycastle.asn1;

/**
 * DER NumericString object - this is an ascii string of characters {0,1,2,3,4,5,6,7,8,9, }.
 * ASN.1 NUMERIC-STRING object.
 * <p>
 * This is an ASCII string of characters {0,1,2,3,4,5,6,7,8,9} + space.
 * <p>
 * See X.680 section 37.2.
 * <p>
 * Explicit character set escape sequences are not allowed.
 */
public class DERNumericString
    extends ASN1NumericString
{
    /**
     * Basic constructor -  without validation..
     */
    public DERNumericString(String string)
    {
        this(string, false);
    }

    /**
     * Constructor with optional validation.
     *
     * @param string the base string to wrap.
     * @param validate whether or not to check the string.
     * @throws IllegalArgumentException if validate is true and the string
     * contains characters that should not be in a NumericString.
     */
    public DERNumericString(String string, boolean validate)
    {
        super(string, validate);
    }

    DERNumericString(byte[] contents, boolean clone)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
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
        out.writeEncoded(withTag, BERTags.NUMERIC_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
        ASN1Primitive o)
    {
        if (!(o instanceof DERNumericString))
        {
            return false;
        }

        DERNumericString  s = (DERNumericString)o;

        return Arrays.areEqual(string, s.string);
    }

    /**
     * Return true if the string can be represented as a NumericString ('0'..'9', ' ')
     *
     * @param str string to validate.
     * @return true if numeric, fale otherwise.
     */
    public static boolean isNumericString(
        String  str)
    {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);

            if (ch > 0x007f)
            {
                return false;
            }

            if (('0' <= ch && ch <= '9') || ch == ' ')
            {
                continue;
            }

            return false;
        }

        return true;
=======
        super(contents, clone);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
}
