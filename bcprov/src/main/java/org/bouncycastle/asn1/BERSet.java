package org.bouncycastle.asn1;

import java.io.IOException;

/**
 * Indefinite length <code>SET</code> and <code>SET OF</code> constructs.
 * <p>
 * Note: This does not know which syntax the set is!
 * </p><p>
 * Length field has value 0x80, and the set ends with two bytes of: 0x00, 0x00.
 * </p><p>
 * For X.690 syntax rules, see {@link ASN1Set}.
 * </p><p>
 * In brief: Constructing this form does not sort the supplied elements,
 * nor does the sorting happen before serialization. This is different
 * from the way {@link DERSet} does things.
 * </p>
 */
public class BERSet
    extends ASN1Set
{
    /**
     * Create an empty SET.
     */
    public BERSet()
    {
    }

    /**
     * Create a SET containing one object.
     *
     * @param element - a single object that makes up the set.
     */
    public BERSet(ASN1Encodable element)
    {
        super(element);
    }

    /**
     * Create a SET containing multiple objects.
     * @param elementVector a vector of objects making up the set.
     */
    public BERSet(ASN1EncodableVector elementVector)
    {
        super(elementVector, false);
    }

    /**
     * Create a SET from an array of objects.
     * @param elements an array of ASN.1 objects.
     */
    public BERSet(ASN1Encodable[] elements)
    {
        super(elements, false);
    }

    BERSet(boolean isSorted, ASN1Encodable[] elements)
    {
        super(isSorted, elements);
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    int encodedLength() throws IOException
    {
        int count = elements.length;
        int totalLength = 0;

        for (int i = 0; i < count; ++i)
=======
    int encodedLength(boolean withTag) throws IOException
    {
        int totalLength = withTag ? 4 : 3;

        for (int i = 0, count = elements.length; i < count; ++i)
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        {
            ASN1Primitive p = elements[i].toASN1Primitive();
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
            totalLength += p.encodedLength();
=======
            totalLength += p.encodedLength(true);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        return 2 + totalLength + 2;
=======
        return totalLength;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        out.writeEncodedIndef(withTag, BERTags.SET | BERTags.CONSTRUCTED, elements);
=======
        out.writeEncodingIL(withTag, BERTags.CONSTRUCTED | BERTags.SET, elements);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
}
