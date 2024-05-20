package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Stream that outputs encoding based on definite length.
 */
class DLOutputStream
    extends ASN1OutputStream
{
    DLOutputStream(OutputStream os)
    {
        super(os);
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    void writePrimitive(ASN1Primitive primitive, boolean withTag) throws IOException
=======
    DLOutputStream getDLSubStream()
    {
        return this;
    }

    void writeElements(ASN1Encodable[] elements)
        throws IOException
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        primitive.toDLObject().encode(this, withTag);
    }

    ASN1OutputStream getDLSubStream()
    {
        return this;
=======
        for (int i = 0, count = elements.length; i < count; ++i)
        {
            elements[i].toASN1Primitive().toDLObject().encode(this, true);
        }
    }

    void writePrimitive(ASN1Primitive primitive, boolean withTag) throws IOException
    {
        primitive.toDLObject().encode(this, withTag);
    }

    void writePrimitives(ASN1Primitive[] primitives)
        throws IOException
    {
        int count = primitives.length;
        for (int i = 0; i < count; ++i)
        {
            primitives[i].toDLObject().encode(this, true);
        }
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }
}
