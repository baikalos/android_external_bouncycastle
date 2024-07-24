package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Stream that outputs encoding based on distinguished encoding rules.
 */
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
// BEGIN Android-changed: Class is package-private in upstream.
// Leaving as public as it's used by build/make/tools/signapk/src/com/android/signapk/SignApk.java
public class DEROutputStream
    extends ASN1OutputStream
=======
class DEROutputStream
    extends DLOutputStream
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
{
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    public DEROutputStream(OutputStream os)
=======
    DEROutputStream(OutputStream os)
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
        super(os);
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    void writePrimitive(ASN1Primitive primitive, boolean withTag) throws IOException
=======
    DEROutputStream getDERSubStream()
    {
        return this;
    }

    void writeElements(ASN1Encodable[] elements)
        throws IOException
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        primitive.toDERObject().encode(this, withTag);
=======
        for (int i = 0, count = elements.length; i < count; ++i)
        {
            elements[i].toASN1Primitive().toDERObject().encode(this, true);
        }
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    DEROutputStream getDERSubStream()
=======
    void writePrimitive(ASN1Primitive primitive, boolean withTag) throws IOException
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    {
        primitive.toDERObject().encode(this, withTag);
    }

    void writePrimitives(ASN1Primitive[] primitives)
        throws IOException
    {
        int count = primitives.length;
        for (int i = 0; i < count; ++i)
        {
            primitives[i].toDERObject().encode(this, true);
        }
    }
}
