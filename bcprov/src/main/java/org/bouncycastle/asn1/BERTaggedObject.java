package org.bouncycastle.asn1;

import java.io.IOException;

/**
 * BER TaggedObject - in ASN.1 notation this is any object preceded by
 * a [n] where n is some number - these are assumed to follow the construction
 * rules (as with sequences).
 */
public class BERTaggedObject
    extends ASN1TaggedObject
{
    /**
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    public BERTaggedObject(int tagNo, ASN1Encodable obj)
    {
        super(true, tagNo, obj);
    }

    public BERTaggedObject(int tagClass, int tagNo, ASN1Encodable obj)
    {
        super(true, tagClass, tagNo, obj);
    }

    /**
     * @param explicit true if an explicitly tagged object.
     * @param tagNo the tag number for this object.
     * @param obj the tagged object.
     */
    public BERTaggedObject(boolean explicit, int tagNo, ASN1Encodable obj)
    {
        super(explicit, tagNo, obj);
    }

    public BERTaggedObject(boolean explicit, int tagClass, int tagNo, ASN1Encodable obj)
    {
        super(explicit, tagClass, tagNo, obj);
    }

    BERTaggedObject(int explicitness, int tagClass, int tagNo, ASN1Encodable obj)
    {
<<<<<<< HEAD
        return explicit || obj.toASN1Primitive().isConstructed();
=======
        super(explicitness, tagClass, tagNo, obj);
    }

    boolean encodeConstructed()
    {
        return isExplicit() || obj.toASN1Primitive().encodeConstructed();
    }

    int encodedLength(boolean withTag) throws IOException
    {
        ASN1Primitive primitive = obj.toASN1Primitive();
        boolean explicit = isExplicit();

        int length = primitive.encodedLength(explicit);

        if (explicit)
        {
            length += 3;
        }

        length += withTag ? ASN1OutputStream.getLengthOfIdentifier(tagNo) : 0;

        return length;
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
//        assert out.getClass().isAssignableFrom(ASN1OutputStream.class);

        ASN1Primitive primitive = obj.toASN1Primitive();
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
            out.write(0x80);
            primitive.encode(out, true);
            out.write(0x00);
            out.write(0x00);
        }
        else
        {
            primitive.encode(out, false);
        }
>>>>>>> aosp/upstream-master
    }

    ASN1Sequence rebuildConstructed(ASN1Primitive primitive)
    {
<<<<<<< HEAD
        ASN1Primitive primitive = obj.toASN1Primitive();
        int length = primitive.encodedLength();

        if (explicit)
        {
            return StreamUtil.calculateTagLength(tagNo) + StreamUtil.calculateBodyLength(length) + length;
        }
        else
        {
            // header length already in calculation
            length = length - 1;

            return StreamUtil.calculateTagLength(tagNo) + length;
        }
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
        out.writeTag(withTag, BERTags.CONSTRUCTED | BERTags.TAGGED, tagNo);
        out.write(0x80);

        if (!explicit)
        {
            Enumeration e;
            if (obj instanceof ASN1OctetString)
            {
                if (obj instanceof BEROctetString)
                {
                    e = ((BEROctetString)obj).getObjects();
                }
                else
                {
                    ASN1OctetString octs = (ASN1OctetString)obj;
                    BEROctetString berO = new BEROctetString(octs.getOctets());
                    e = berO.getObjects();
                }
            }
            else if (obj instanceof ASN1Sequence)
            {
                e = ((ASN1Sequence)obj).getObjects();
            }
            else if (obj instanceof ASN1Set)
            {
                e = ((ASN1Set)obj).getObjects();
            }
            else
            {
                throw new ASN1Exception("not implemented: " + obj.getClass().getName());
            }

            out.writeElements(e);
        }
        else
        {
            out.writePrimitive(obj.toASN1Primitive(), true);
        }

        out.write(0x00);
        out.write(0x00);

//        ASN1Primitive primitive = obj.toASN1Primitive();
//
//        int flags = BERTags.TAGGED;
//        if (explicit || primitive.isConstructed())
//        {
//            flags |= BERTags.CONSTRUCTED;
//        }
//
//        out.writeTag(withTag, flags, tagNo);
//
//        if (explicit)
//        {
//            out.write(0x80);
//            out.writePrimitive(obj.toASN1Primitive(), true);
//            out.write(0x00);
//            out.write(0x00);
//        }
//        else
//        {
//            out.writePrimitive(obj.toASN1Primitive(), false);
//        }
=======
        return new BERSequence(primitive);
    }

    ASN1TaggedObject replaceTag(int tagClass, int tagNo)
    {
        return new BERTaggedObject(explicitness, tagClass, tagNo, obj);
>>>>>>> aosp/upstream-master
    }
}
