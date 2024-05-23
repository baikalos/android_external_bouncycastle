package org.bouncycastle.asn1;

/**
 * DER PrintableString object.
 * <p>
 * X.680 section 37.4 defines PrintableString character codes as ASCII subset of following characters:
 * </p>
 * <ul>
 * <li>Latin capital letters: 'A' .. 'Z'</li>
 * <li>Latin small letters: 'a' .. 'z'</li>
 * <li>Digits: '0'..'9'</li>
 * <li>Space</li>
 * <li>Apostrophe: '\''</li>
 * <li>Left parenthesis: '('</li>
 * <li>Right parenthesis: ')'</li>
 * <li>Plus sign: '+'</li>
 * <li>Comma: ','</li>
 * <li>Hyphen-minus: '-'</li>
 * <li>Full stop: '.'</li>
 * <li>Solidus: '/'</li>
 * <li>Colon: ':'</li>
 * <li>Equals sign: '='</li>
 * <li>Question mark: '?'</li>
 * </ul>
 * <p>
 * Explicit character set escape sequences are not allowed.
 * </p>
 */
public class DERPrintableString
    extends ASN1PrintableString
{
    /**
     * Basic constructor - this does not validate the string
     */
    public DERPrintableString(
        String   string)
    {
        this(string, false);
    }

    /**
     * Constructor with optional validation.
     *
     * @param string the base string to wrap.
     * @param validate whether or not to check the string.
     * @throws IllegalArgumentException if validate is true and the string
     * contains characters that should not be in a PrintableString.
     */
    public DERPrintableString(
        String   string,
        boolean  validate)
    {
        super(string, validate);
    }

    DERPrintableString(byte[] contents, boolean clone)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        return Strings.fromByteArray(string);
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
        out.writeEncoded(withTag, BERTags.PRINTABLE_STRING, string);
    }

    public int hashCode()
    {
        return Arrays.hashCode(string);
    }

    boolean asn1Equals(
        ASN1Primitive o)
    {
        if (!(o instanceof DERPrintableString))
        {
            return false;
        }

        DERPrintableString  s = (DERPrintableString)o;

        return Arrays.areEqual(string, s.string);
    }

    public String toString()
    {
        return getString();
    }

    /**
     * return true if the passed in String can be represented without
     * loss as a PrintableString, false otherwise.
     *
     * @return true if in printable set, false otherwise.
     */
    public static boolean isPrintableString(
        String  str)
    {
        for (int i = str.length() - 1; i >= 0; i--)
        {
            char    ch = str.charAt(i);

            if (ch > 0x007f)
            {
                return false;
            }

            if ('a' <= ch && ch <= 'z')
            {
                continue;
            }

            if ('A' <= ch && ch <= 'Z')
            {
                continue;
            }

            if ('0' <= ch && ch <= '9')
            {
                continue;
            }

            switch (ch)
            {
            case ' ':
            case '\'':
            case '(':
            case ')':
            case '+':
            case '-':
            case '.':
            case ':':
            case '=':
            case '?':
            case '/':
            case ',':
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
