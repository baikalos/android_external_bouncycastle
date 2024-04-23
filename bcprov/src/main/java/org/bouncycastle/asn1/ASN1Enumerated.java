package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;

import org.bouncycastle.util.Arrays;

/**
 * Class representing the ASN.1 ENUMERATED type.
 */
public class ASN1Enumerated
    extends ASN1Primitive
{
<<<<<<< HEAD
    private final byte[] bytes;
    private final int start;
=======
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1Enumerated.class, BERTags.ENUMERATED)
    {
        ASN1Primitive fromImplicitPrimitive(DEROctetString octetString)
        {
            return createPrimitive(octetString.getOctets(), false);
        }
    };
>>>>>>> aosp/upstream-master

    /**
     * return an enumerated from the passed in object
     *
     * @param obj an ASN1Enumerated or an object that can be converted into one.
     * @exception IllegalArgumentException if the object cannot be converted.
     * @return an ASN1Enumerated instance, or null.
     */
    public static ASN1Enumerated getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof ASN1Enumerated)
        {
            return (ASN1Enumerated)obj;
        }

        if (obj instanceof byte[])
        {
            try
            {
                return (ASN1Enumerated)TYPE.fromByteArray((byte[])obj);
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
            }
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return an Enumerated from a tagged object.
     *
     * @param taggedObject the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     * @return an ASN1Enumerated instance, or null.
     */
    public static ASN1Enumerated getInstance(ASN1TaggedObject taggedObject, boolean explicit)
    {
<<<<<<< HEAD
        ASN1Primitive o = obj.getObject();

        if (explicit || o instanceof ASN1Enumerated)
        {
            return getInstance(o);
        }
        else
        {
            return fromOctetString(ASN1OctetString.getInstance(o).getOctets());
        }
=======
        return (ASN1Enumerated)TYPE.getContextInstance(taggedObject, explicit);
>>>>>>> aosp/upstream-master
    }

    private final byte[] contents;
    private final int start;

    /**
     * Constructor from int.
     *
     * @param value the value of this enumerated.
     */
    public ASN1Enumerated(int value)
    {
        if (value < 0)
        {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }

<<<<<<< HEAD
        this.bytes = BigInteger.valueOf(value).toByteArray();
=======
        this.contents = BigInteger.valueOf(value).toByteArray();
>>>>>>> aosp/upstream-master
        this.start = 0;
    }

    /**
     * Constructor from BigInteger
     *
     * @param value the value of this enumerated.
     */
    public ASN1Enumerated(BigInteger value)
    {
        if (value.signum() < 0)
        {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }

<<<<<<< HEAD
        this.bytes = value.toByteArray();
=======
        this.contents = value.toByteArray();
>>>>>>> aosp/upstream-master
        this.start = 0;
    }

    /**
     * Constructor from encoded BigInteger.
     *
     * @param contents the value of this enumerated as an encoded BigInteger (signed).
     */
<<<<<<< HEAD
    public ASN1Enumerated(byte[] bytes)
    {
        if (ASN1Integer.isMalformed(bytes))
        {
            throw new IllegalArgumentException("malformed enumerated");
        }
        if (0 != (bytes[0] & 0x80))
=======
    public ASN1Enumerated(byte[] contents)
    {
        this(contents, true);
    }

    ASN1Enumerated(byte[] contents, boolean clone)
    {
        if (ASN1Integer.isMalformed(contents))
        {
            throw new IllegalArgumentException("malformed enumerated");
        }
        if (0 != (contents[0] & 0x80))
>>>>>>> aosp/upstream-master
        {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }

<<<<<<< HEAD
        this.bytes = Arrays.clone(bytes);
        this.start = ASN1Integer.signBytesToSkip(bytes); 
=======
        this.contents = clone ? Arrays.clone(contents) : contents;
        this.start = ASN1Integer.signBytesToSkip(contents); 
>>>>>>> aosp/upstream-master
    }

    public BigInteger getValue()
    {
        return new BigInteger(contents);
    }

<<<<<<< HEAD
=======
    public boolean hasValue(int x)
    {
        return (contents.length - start) <= 4
            && ASN1Integer.intValue(contents, start, ASN1Integer.SIGN_EXT_SIGNED) == x;
    }

>>>>>>> aosp/upstream-master
    public boolean hasValue(BigInteger x)
    {
        return null != x
            // Fast check to avoid allocation
<<<<<<< HEAD
            && ASN1Integer.intValue(bytes, start, ASN1Integer.SIGN_EXT_SIGNED) == x.intValue()
=======
            && ASN1Integer.intValue(contents, start, ASN1Integer.SIGN_EXT_SIGNED) == x.intValue()
>>>>>>> aosp/upstream-master
            && getValue().equals(x);
    }

    public int intValueExact()
    {
<<<<<<< HEAD
        int count = bytes.length - start;
=======
        int count = contents.length - start;
>>>>>>> aosp/upstream-master
        if (count > 4)
        {
            throw new ArithmeticException("ASN.1 Enumerated out of int range");
        }

<<<<<<< HEAD
        return ASN1Integer.intValue(bytes, start, ASN1Integer.SIGN_EXT_SIGNED); 
    }

    boolean isConstructed()
=======
        return ASN1Integer.intValue(contents, start, ASN1Integer.SIGN_EXT_SIGNED); 
    }

    boolean encodeConstructed()
>>>>>>> aosp/upstream-master
    {
        return false;
    }

    int encodedLength(boolean withTag)
    {
        return ASN1OutputStream.getLengthOfEncodingDL(withTag, contents.length);
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
<<<<<<< HEAD
        out.writeEncoded(withTag, BERTags.ENUMERATED, bytes);
=======
        out.writeEncodingDL(withTag, BERTags.ENUMERATED, contents);
>>>>>>> aosp/upstream-master
    }

    boolean asn1Equals(
        ASN1Primitive  o)
    {
        if (!(o instanceof ASN1Enumerated))
        {
            return false;
        }

        ASN1Enumerated other = (ASN1Enumerated)o;

        return Arrays.areEqual(this.contents, other.contents);
    }

    public int hashCode()
    {
        return Arrays.hashCode(contents);
    }

    private static final ASN1Enumerated[] cache = new ASN1Enumerated[12];

    static ASN1Enumerated createPrimitive(byte[] contents, boolean clone)
    {
        if (contents.length > 1)
        {
            return new ASN1Enumerated(contents, clone);
        }

        if (contents.length == 0)
        {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int value = contents[0] & 0xff;

        if (value >= cache.length)
        {
<<<<<<< HEAD
            return new ASN1Enumerated(enc);
=======
            return new ASN1Enumerated(contents, clone);
>>>>>>> aosp/upstream-master
        }

        ASN1Enumerated possibleMatch = cache[value];

        if (possibleMatch == null)
        {
<<<<<<< HEAD
            possibleMatch = cache[value] = new ASN1Enumerated(enc);
=======
            possibleMatch = cache[value] = new ASN1Enumerated(contents, clone);
>>>>>>> aosp/upstream-master
        }

        return possibleMatch;
    }
}
