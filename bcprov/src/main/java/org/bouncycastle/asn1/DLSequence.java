package org.bouncycastle.asn1;

import java.io.IOException;

/**
 * The DLSequence encodes a SEQUENCE using definite length form.
 */
public class DLSequence
    extends ASN1Sequence
{
    private int contentsLength = -1;

    /**
     * Create an empty sequence
     */
    public DLSequence()
    {
    }

    /**
     * create a sequence containing one object
     * @param element the object to go in the sequence.
     */
    public DLSequence(ASN1Encodable element)
    {
        super(element);
    }

    /**
     * create a sequence containing a vector of objects.
     * @param elementVector the vector of objects to make up the sequence.
     */
    public DLSequence(ASN1EncodableVector elementVector)
    {
        super(elementVector);
    }

    /**
     * create a sequence containing an array of objects.
     * @param elements the array of objects to make up the sequence.
     */
    public DLSequence(ASN1Encodable[] elements)
    {
        super(elements);
    }

    DLSequence(ASN1Encodable[] elements, boolean clone)
<<<<<<< HEAD
    {
        super(elements, clone);
    }

    private int getBodyLength() throws IOException
=======
>>>>>>> aosp/upstream-master
    {
        super(elements, clone);
    }

    private int getContentsLength() throws IOException
    {
        if (contentsLength < 0)
        {
            int count = elements.length;
            int totalLength = 0;

            for (int i = 0; i < count; ++i)
            {
                ASN1Primitive dlObject = elements[i].toASN1Primitive().toDLObject();
<<<<<<< HEAD
                totalLength += dlObject.encodedLength();
            }

            this.bodyLength = totalLength;
=======
                totalLength += dlObject.encodedLength(true);
            }

            this.contentsLength = totalLength;
>>>>>>> aosp/upstream-master
        }

        return contentsLength;
    }

<<<<<<< HEAD
    int encodedLength() throws IOException
=======
    int encodedLength(boolean withTag) throws IOException
>>>>>>> aosp/upstream-master
    {
        return ASN1OutputStream.getLengthOfEncodingDL(withTag, getContentsLength());
    }

    /**
     * A note on the implementation:
     * <p>
     * As DL requires the constructed, definite-length model to
     * be used for structured types, this varies slightly from the
     * ASN.1 descriptions given. Rather than just outputting SEQUENCE,
     * we also have to specify CONSTRUCTED, and the objects length.
     */
    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
<<<<<<< HEAD
        if (withTag)
        {
            out.write(BERTags.SEQUENCE | BERTags.CONSTRUCTED);
        }

        ASN1OutputStream dlOut = out.getDLSubStream();

        int count = elements.length;
        if (bodyLength >= 0 || count > 16)
        {
            out.writeLength(getBodyLength());

=======
        out.writeIdentifier(withTag, BERTags.CONSTRUCTED | BERTags.SEQUENCE);

        ASN1OutputStream dlOut = out.getDLSubStream();

        int count = elements.length;
        if (contentsLength >= 0 || count > 16)
        {
            out.writeDL(getContentsLength());

>>>>>>> aosp/upstream-master
            for (int i = 0; i < count; ++i)
            {
                dlOut.writePrimitive(elements[i].toASN1Primitive(), true);
            }
        }
        else
        {
            int totalLength = 0;

            ASN1Primitive[] dlObjects = new ASN1Primitive[count];
            for (int i = 0; i < count; ++i)
            {
                ASN1Primitive dlObject = elements[i].toASN1Primitive().toDLObject();
                dlObjects[i] = dlObject;
<<<<<<< HEAD
                totalLength += dlObject.encodedLength();
            }

            this.bodyLength = totalLength;
            out.writeLength(totalLength);
=======
                totalLength += dlObject.encodedLength(true);
            }

            this.contentsLength = totalLength;
            out.writeDL(totalLength);
>>>>>>> aosp/upstream-master

            for (int i = 0; i < count; ++i)
            {
                dlOut.writePrimitive(dlObjects[i], true);
            }
        }
    }

<<<<<<< HEAD
=======
    ASN1BitString toASN1BitString()
    {
        return new DLBitString(BERBitString.flattenBitStrings(getConstructedBitStrings()), false);
    }

    ASN1External toASN1External()
    {
        return new DLExternal(this);
    }

    ASN1OctetString toASN1OctetString()
    {
        // NOTE: There is no DLOctetString
        return new DEROctetString(BEROctetString.flattenOctetStrings(getConstructedOctetStrings()));
    }

    ASN1Set toASN1Set()
    {
        return new DLSet(false, toArrayInternal());
    }

>>>>>>> aosp/upstream-master
    ASN1Primitive toDLObject()
    {
        return this;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> aosp/upstream-master
