package org.bouncycastle.asn1;

import java.io.IOException;

/**
 * Carrier class for a DER encoding OCTET STRING
 */
public class DEROctetString
    extends ASN1OctetString
{
    /**
     * Base constructor.
     *
     * @param string the octets making up the octet string.
     */
    public DEROctetString(
        byte[]  string)
    {
        super(string);
    }

    /**
     * Constructor from the encoding of an ASN.1 object.
     *
     * @param obj the object to be encoded.
     */
    public DEROctetString(
        ASN1Encodable obj)
        throws IOException
    {
        super(obj.toASN1Primitive().getEncoded(ASN1Encoding.DER));
    }

    boolean encodeConstructed()
    {
        return false;
    }

    int encodedLength(boolean withTag)
    {
        return ASN1OutputStream.getLengthOfEncodingDL(withTag, string.length);
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        out.writeEncoded(withTag, BERTags.OCTET_STRING, string);
=======
        out.writeEncodingDL(withTag, BERTags.OCTET_STRING, string);
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

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    static void encode(ASN1OutputStream derOut, boolean withTag, byte[] buf, int off, int len) throws IOException
    {
        derOut.writeEncoded(withTag, BERTags.OCTET_STRING, buf, off, len);
=======
    static void encode(ASN1OutputStream out, boolean withTag, byte[] buf, int off, int len) throws IOException
    {
        out.writeEncodingDL(withTag, BERTags.OCTET_STRING, buf, off, len);
    }

    static int encodedLength(boolean withTag, int contentsLength)
    {
        return ASN1OutputStream.getLengthOfEncodingDL(withTag, contentsLength);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
}
