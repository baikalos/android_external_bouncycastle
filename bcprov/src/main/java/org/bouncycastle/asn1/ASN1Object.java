package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.bouncycastle.util.Encodable;

/**
 * Base class for defining an ASN.1 object.
 */
public abstract class ASN1Object
    implements ASN1Encodable, Encodable
{
    public void encodeTo(OutputStream output) throws IOException
    {
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        ASN1OutputStream.create(output).writeObject(this);
    }

    public void encodeTo(OutputStream output, String encoding) throws IOException
    {
        ASN1OutputStream.create(output, encoding).writeObject(this);
=======
        toASN1Primitive().encodeTo(output);
    }

    public void encodeTo(OutputStream output, String encoding) throws IOException
    {
        toASN1Primitive().encodeTo(output, encoding);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    /**
     * Return the default BER or DER encoding for this object.
     *
     * @return BER/DER byte encoded object.
     * @throws java.io.IOException on encoding error.
     */
    public byte[] getEncoded() throws IOException
    {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        encodeTo(bOut);
=======
        toASN1Primitive().encodeTo(bOut);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        return bOut.toByteArray();
    }

    /**
     * Return either the default for "BER" or a DER encoding if "DER" is specified.
     *
     * @param encoding name of encoding to use.
     * @return byte encoded object.
     * @throws IOException on encoding error.
     */
    public byte[] getEncoded(String encoding) throws IOException
    {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
        encodeTo(bOut, encoding);
=======
        toASN1Primitive().encodeTo(bOut, encoding);
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
        return bOut.toByteArray();
    }

    public int hashCode()
    {
        return this.toASN1Primitive().hashCode();
    }

    public boolean equals(
        Object  o)
    {
        if (this == o)
        {
            return true;
        }

        if (!(o instanceof ASN1Encodable))
        {
            return false;
        }

        ASN1Encodable other = (ASN1Encodable)o;

        return this.toASN1Primitive().equals(other.toASN1Primitive());
    }

    // BEGIN Android-changed: Was removed in upstream.
    // Used by https://source.corp.google.com/android/cts/tests/tests/keystore/src/android/keystore/cts/KeyAttestationTest.java
    /**
<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
     * @deprecated use toASN1Primitive()
     * @return the underlying primitive type.
     */
    public ASN1Primitive toASN1Object()
    {
        return this.toASN1Primitive();
    }
    // END Android-changed

    /**
=======
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
     * Return true if obj is a byte array and represents an object with the given tag value.
     *
     * @param obj object of interest.
     * @param tagValue tag value to check for.
     * @return  true if obj is a byte encoding starting with the given tag value, false otherwise.
     */
    protected static boolean hasEncodedTagValue(Object obj, int tagValue)
    {
        return (obj instanceof byte[]) && ((byte[])obj)[0] == tagValue;
    }

    /**
     * Method providing a primitive representation of this object suitable for encoding.
     * @return a primitive representation of this object.
     */
    public abstract ASN1Primitive toASN1Primitive();
}
