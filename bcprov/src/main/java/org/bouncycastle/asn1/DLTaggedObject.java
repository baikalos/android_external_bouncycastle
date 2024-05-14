package org.bouncycastle.asn1;

import java.io.IOException;

/**
 * Definite Length TaggedObject - in ASN.1 notation this is any object preceded by
 * a [n] where n is some number - these are assumed to follow the construction
 * rules (as with sequences).
 */
public class DLTaggedObject
    extends ASN1TaggedObject
{
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
    public DLTaggedObject(int tagNo, ASN1Encodable encodable)
    {
        super(true, tagNo, encodable);
    }

    public DLTaggedObject(int tagClass, int tagNo, ASN1Encodable encodable)
    {
        super(true, tagClass, tagNo, encodable);
    }

>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    /**
     * @param explicit true if an explicitly tagged object.
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    public DLTaggedObject(boolean explicit, int tagNo, ASN1Encodable obj)
    {
        super(explicit, tagNo, obj);
    }

    public DLTaggedObject(boolean explicit, int tagClass, int tagNo, ASN1Encodable obj)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        return explicit || obj.toASN1Primitive().toDLObject().isConstructed();
=======
        super(explicit, tagClass, tagNo, obj);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    DLTaggedObject(int explicitness, int tagClass, int tagNo, ASN1Encodable obj)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        int length = obj.toASN1Primitive().toDLObject().encodedLength();

        if (explicit)
        {
            return  StreamUtil.calculateTagLength(tagNo) + StreamUtil.calculateBodyLength(length) + length;
        }
        else
        {
            // header length already in calculation
            length = length - 1;

            return StreamUtil.calculateTagLength(tagNo) + length;
        }
=======
        super(explicitness, tagClass, tagNo, obj);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    void encode(ASN1OutputStream out, boolean withTag) throws IOException
=======
    boolean encodeConstructed()
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        ASN1Primitive primitive = obj.toASN1Primitive().toDLObject();
=======
        return isExplicit() || obj.toASN1Primitive().toDLObject().encodeConstructed();
    }
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        int flags = BERTags.TAGGED;
        if (explicit || primitive.isConstructed())
=======
    int encodedLength(boolean withTag) throws IOException
    {
        ASN1Primitive primitive = obj.toASN1Primitive().toDLObject();
        boolean explicit = isExplicit();

        int length = primitive.encodedLength(explicit);

        if (explicit)
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
            flags |= BERTags.CONSTRUCTED;
=======
            length += ASN1OutputStream.getLengthOfDL(length);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        out.writeTag(withTag, flags, tagNo);

        if (explicit)
        {
            out.writeLength(primitive.encodedLength());
        }

        out.getDLSubStream().writePrimitive(primitive, explicit);
=======
        length += withTag ? ASN1OutputStream.getLengthOfIdentifier(tagNo) : 0;

        return length;
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
//        assert out.getClass().isAssignableFrom(DLOutputStream.class);

        ASN1Primitive primitive = obj.toASN1Primitive().toDLObject();
        boolean explicit = isExplicit();

        if (withTag)
        {
            int flags = tagClass;
            if (explicit || primitive.encodeConstructed())
            {
                flags |= BERTags.CONSTRUCTED;
            }

            out.writeIdentifier(true, flags, tagNo);
        }

        if (explicit)
        {
            out.writeDL(primitive.encodedLength(true));
        }

        primitive.encode(out.getDLSubStream(), explicit);
    }

    ASN1Sequence rebuildConstructed(ASN1Primitive primitive)
    {
        return new DLSequence(primitive);
    }

    ASN1TaggedObject replaceTag(int tagClass, int tagNo)
    {
        return new DLTaggedObject(explicitness, tagClass, tagNo, obj);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    ASN1Primitive toDLObject()
    {
        return this;
    }
}
