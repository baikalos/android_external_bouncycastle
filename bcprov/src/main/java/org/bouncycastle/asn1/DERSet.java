package org.bouncycastle.asn1;

import java.io.IOException;

/**
 * A DER encoded SET object
 * <p>
 * For X.690 syntax rules, see {@link ASN1Set}.
 * </p><p>
 * For short: Constructing this form does sort the supplied elements,
 * and the sorting happens also before serialization (if necesssary).
 * This is different from the way {@link BERSet},{@link DLSet} does things.
 * </p>
 */
public class DERSet
    extends ASN1Set
{
    public static DERSet convert(ASN1Set set)
    {
        return (DERSet)set.toDERObject();
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    private int bodyLength = -1;
=======
    private int contentsLength = -1;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

    /**
     * create an empty set
     */
    public DERSet()
    {
    }

    /**
     * create a set containing one object
     * @param element the object to go in the set
     */
    public DERSet(ASN1Encodable element)
    {
        super(element);
    }

    /**
     * create a set containing a vector of objects.
     * @param elementVector the vector of objects to make up the set.
     */
    public DERSet(ASN1EncodableVector elementVector)
    {
        super(elementVector, true);
    }

    /**
     * create a set containing an array of objects.
     * @param elements the array of objects to make up the set.
     */
    public DERSet(ASN1Encodable[] elements)
    {
        super(elements, true);
    }

    DERSet(boolean isSorted, ASN1Encodable[] elements)
    {
        super(checkSorted(isSorted), elements);
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    private int getBodyLength() throws IOException
=======
    private int getContentsLength() throws IOException
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
        if (contentsLength < 0)
        {
            int count = elements.length;
            int totalLength = 0;

            for (int i = 0; i < count; ++i)
            {
                ASN1Primitive derObject = elements[i].toASN1Primitive().toDERObject();
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
                totalLength += derObject.encodedLength();
=======
                totalLength += derObject.encodedLength(true);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
            }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
            this.bodyLength = totalLength;
=======
            this.contentsLength = totalLength;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        }

        return contentsLength;
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    int encodedLength() throws IOException
=======
    int encodedLength(boolean withTag) throws IOException
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
        return ASN1OutputStream.getLengthOfEncodingDL(withTag, getContentsLength());
    }

    /*
     * A note on the implementation:
     * <p>
     * As DER requires the constructed, definite-length model to
     * be used for structured types, this varies slightly from the
     * ASN.1 descriptions given. Rather than just outputting SET,
     * we also have to specify CONSTRUCTED, and the objects length.
     */
    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        if (withTag)
=======
        out.writeIdentifier(withTag, BERTags.CONSTRUCTED | BERTags.SET);

        DEROutputStream derOut = out.getDERSubStream();

        int count = elements.length;
        if (contentsLength >= 0 || count > 16)
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
            out.write(BERTags.SET | BERTags.CONSTRUCTED);
=======
            out.writeDL(getContentsLength());

            for (int i = 0; i < count; ++i)
            {
                ASN1Primitive derObject = elements[i].toASN1Primitive().toDERObject();
                derObject.encode(derOut, true);
            }
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        }
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)

        DEROutputStream derOut = out.getDERSubStream();

        int count = elements.length;
        if (bodyLength >= 0 || count > 16)
        {
            out.writeLength(getBodyLength());

            for (int i = 0; i < count; ++i)
            {
                ASN1Primitive derObject = elements[i].toASN1Primitive().toDERObject();
                derObject.encode(derOut, true);
            }
        }
        else
        {
            int totalLength = 0;

            ASN1Primitive[] derObjects = new ASN1Primitive[count];
            for (int i = 0; i < count; ++i)
            {
                ASN1Primitive derObject = elements[i].toASN1Primitive().toDERObject();
                derObjects[i] = derObject;
                totalLength += derObject.encodedLength();
            }

            this.bodyLength = totalLength;
            out.writeLength(totalLength);

            for (int i = 0; i < count; ++i)
            {
                derObjects[i].encode(derOut, true);
            }
        }
    }

    ASN1Primitive toDERObject()
    {
        return isSorted ? this : super.toDERObject();
=======
        else
        {
            int totalLength = 0;

            ASN1Primitive[] derObjects = new ASN1Primitive[count];
            for (int i = 0; i < count; ++i)
            {
                ASN1Primitive derObject = elements[i].toASN1Primitive().toDERObject();
                derObjects[i] = derObject;
                totalLength += derObject.encodedLength(true);
            }

            this.contentsLength = totalLength;
            out.writeDL(totalLength);

            for (int i = 0; i < count; ++i)
            {
                derObjects[i].encode(derOut, true);
            }
        }
    }

    ASN1Primitive toDERObject()
    {
        return (sortedElements != null) ? this : super.toDERObject();
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    ASN1Primitive toDLObject()
    {
        return this;
    }

    private static boolean checkSorted(boolean isSorted)
    {
        if (!isSorted)
        {
            throw new IllegalStateException("DERSet elements should always be in sorted order");
        }
        return isSorted;
    }
}
