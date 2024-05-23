package org.bouncycastle.asn1;

import java.io.IOException;
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
import java.util.Enumeration;
import java.util.NoSuchElementException;
=======
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

/**
 * ASN.1 OctetStrings, with indefinite length rules, and <i>constructed form</i> support.
 * <p>
 * The Basic Encoding Rules (BER) format allows encoding using so called "<i>constructed form</i>",
 * which DER and CER formats forbid allowing only "primitive form".
 * </p><p>
 * This class <b>always</b> produces the constructed form with underlying segments
 * in an indefinite length array.  If the input wasn't the same, then this output
 * is not faithful reproduction.
 * </p>
 * <p>
 * See {@link ASN1OctetString} for X.690 encoding rules of OCTET-STRING objects.
 * </p>
 */
public class BEROctetString
    extends ASN1OctetString
{
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    private static final int DEFAULT_CHUNK_SIZE = 1000;
=======
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

    private final int segmentLimit;
    private final ASN1OctetString[] elements;

    /**
     * Convert a vector of octet strings into a single byte string
     */
    static byte[] flattenOctetStrings(ASN1OctetString[] octetStrings)
    {
        int count = octetStrings.length;
        switch (count)
        {
        case 0:
            return EMPTY_OCTETS;
        case 1:
            return octetStrings[0].string;
        default:
        {
            int totalOctets = 0;
            for (int i = 0; i < count; ++i)
            {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
                bOut.write(octs[i].getOctets());
=======
                totalOctets += octetStrings[i].string.length;
            }

            byte[] string = new byte[totalOctets];
            for (int i = 0, pos = 0; i < count; ++i)
            {
                byte[] octets = octetStrings[i].string;
                System.arraycopy(octets, 0, string, pos, octets.length);
                pos += octets.length;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
            }

//            assert pos == totalOctets;
            return string;
        }
        }
    }

    /**
     * Create an OCTET-STRING object from a byte[]
     * @param string the octets making up the octet string.
     */
    public BEROctetString(byte[] string)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        this(string, DEFAULT_CHUNK_SIZE);
=======
        this(string, DEFAULT_SEGMENT_LIMIT);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    /**
     * Multiple {@link ASN1OctetString} data blocks are input,
     * the result is <i>constructed form</i>.
     *
     * @param elements an array of OCTET STRING to construct the BER OCTET STRING from.
     */
    public BEROctetString(ASN1OctetString[] elements)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        this(octs, DEFAULT_CHUNK_SIZE);
=======
        this(elements, DEFAULT_SEGMENT_LIMIT);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    /**
     * Create an OCTET-STRING object from a byte[]
     * @param string the octets making up the octet string.
     * @param segmentLimit the number of octets stored in each DER encoded component OCTET STRING.
     */
    public BEROctetString(byte[] string, int segmentLimit)
    {
        this(string, null, segmentLimit);
    }

    /**
     * Multiple {@link ASN1OctetString} data blocks are input,
     * the result is <i>constructed form</i>.
     *
     * @param elements an array of OCTET STRING to construct the BER OCTET STRING from.
     * @param segmentLimit the number of octets stored in each DER encoded component OCTET STRING.
     */
    public BEROctetString(ASN1OctetString[] elements, int segmentLimit)
    {
        this(flattenOctetStrings(elements), elements, segmentLimit);
    }

    private BEROctetString(byte[] string, ASN1OctetString[] elements, int segmentLimit)
    {
        super(string);
        this.elements = elements;
        this.segmentLimit = segmentLimit;
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    /**
     * Return the OCTET STRINGs that make up this string.
     *
     * @return an Enumeration of the component OCTET STRINGs.
     */
    public Enumeration getObjects()
    {
        if (octs == null)
        {
            return new Enumeration()
            {
                int pos = 0;

                public boolean hasMoreElements()
                {
                    return pos < string.length;
                }

                public Object nextElement()
                {
                    if (pos < string.length)
                    {
                        int length = Math.min(string.length - pos, chunkSize);
                        byte[] chunk = new byte[length];
                        System.arraycopy(string, pos, chunk, 0, length);
                        pos += length;
                        return new DEROctetString(chunk);
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        return new Enumeration()
        {
            int counter = 0;

            public boolean hasMoreElements()
            {
                return counter < octs.length;
            }

            public Object nextElement()
            {
                if (counter < octs.length)
                {
                    return octs[counter++];
                }
                throw new NoSuchElementException();
            }
        };
    }

    boolean isConstructed()
=======
    boolean encodeConstructed()
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
        return true;
    }

    int encodedLength(boolean withTag)
        throws IOException
    {
        int totalLength = withTag ? 4 : 3;

        if (null != elements)
        {
            for (int i = 0; i < elements.length; ++i)
            {
                totalLength += elements[i].encodedLength(true);
            }
        }
        else
        {
            int fullSegments = string.length / segmentLimit;
            totalLength += fullSegments * DEROctetString.encodedLength(true, segmentLimit);

            int lastSegmentLength = string.length - (fullSegments * segmentLimit);
            if (lastSegmentLength > 0)
            {
                totalLength += DEROctetString.encodedLength(true, lastSegmentLength);
            }
        }

        return totalLength;
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        out.writeEncodedIndef(withTag, BERTags.CONSTRUCTED | BERTags.OCTET_STRING,  getObjects());
=======
        out.writeIdentifier(withTag, BERTags.CONSTRUCTED | BERTags.OCTET_STRING);
        out.write(0x80);

        if (null != elements)
        {
            out.writePrimitives(elements);
        }
        else
        {
            int pos = 0;
            while (pos < string.length)
            {
                int segmentLength = Math.min(string.length - pos, segmentLimit);
                DEROctetString.encode(out, true, string, pos, segmentLength);
                pos += segmentLength;
            }
        }

        out.write(0x00);
        out.write(0x00);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)

    static BEROctetString fromSequence(ASN1Sequence seq)
    {
        int count = seq.size();
        ASN1OctetString[] v = new ASN1OctetString[count];
        for (int i = 0; i < count; ++i)
        {
            v[i] = ASN1OctetString.getInstance(seq.getObjectAt(i));
        }
        return new BEROctetString(v);
    }
=======
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
}

