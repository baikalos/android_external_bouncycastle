package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Note: this class is for processing DER/DL encoded sequences only.
 */
class LazyEncodedSequence
    extends ASN1Sequence
{
    private byte[] encoded;

    LazyEncodedSequence(byte[] encoded) throws IOException
    {
        // NOTE: Initially, the actual 'elements' will be empty
        super();

<<<<<<< HEAD
        this.encoded = encoded;
    }

    public synchronized ASN1Encodable getObjectAt(int index)
=======
        if (null == encoded)
        {
            throw new NullPointerException("'encoded' cannot be null");
        }

        this.encoded = encoded;
    }

    public ASN1Encodable getObjectAt(int index)
>>>>>>> aosp/upstream-master
    {
        force();

        return super.getObjectAt(index);
    }

    public Enumeration getObjects()
    {
<<<<<<< HEAD
=======
        byte[] encoded = getContents();
>>>>>>> aosp/upstream-master
        if (null != encoded)
        {
            return new LazyConstructionEnumeration(encoded);
        }

        return super.getObjects();
<<<<<<< HEAD
    }

    public synchronized int hashCode()
    {
        force();

        return super.hashCode();
    }

    public synchronized Iterator<ASN1Encodable> iterator()
    {
        force();

        return super.iterator();
=======
>>>>>>> aosp/upstream-master
    }

    public int hashCode()
    {
        force();
<<<<<<< HEAD
=======

        return super.hashCode();
    }

    public Iterator<ASN1Encodable> iterator()
    {
        force();

        return super.iterator();
    }

    public int size()
    {
        force();
>>>>>>> aosp/upstream-master

        return super.size();
    }

<<<<<<< HEAD
    public synchronized ASN1Encodable[] toArray()
    {
        force();

        return super.toArray();
    }

    ASN1Encodable[] toArrayInternal()
    {
        force();

        return super.toArrayInternal();
    }

    synchronized int encodedLength()
        throws IOException
    {
        if (null != encoded)
        {
            return 1 + StreamUtil.calculateBodyLength(encoded.length) + encoded.length;
        }
=======
    public ASN1Encodable[] toArray()
    {
        force();

        return super.toArray();
    }

    ASN1Encodable[] toArrayInternal()
    {
        force();

        return super.toArrayInternal();
    }

    int encodedLength(boolean withTag)
        throws IOException
    {
        byte[] encoded = getContents();
        if (null != encoded)
        {
            return ASN1OutputStream.getLengthOfEncodingDL(withTag, encoded.length);
        }

        return super.toDLObject().encodedLength(withTag);
    }

    void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
        byte[] encoded = getContents();
        if (null != encoded)
        {
            out.writeEncodingDL(withTag, BERTags.CONSTRUCTED | BERTags.SEQUENCE, encoded);
            return;
        }

        super.toDLObject().encode(out, withTag);
    }

    ASN1BitString toASN1BitString()
    {
        return ((ASN1Sequence)toDLObject()).toASN1BitString();
    }

    ASN1External toASN1External()
    {
        return ((ASN1Sequence)toDLObject()).toASN1External();
    }

    ASN1OctetString toASN1OctetString()
    {
        return ((ASN1Sequence)toDLObject()).toASN1OctetString();
    }

    ASN1Set toASN1Set()
    {
        return ((ASN1Sequence)toDLObject()).toASN1Set();
    }

    ASN1Primitive toDERObject()
    {
        force();
>>>>>>> aosp/upstream-master

        return super.toDLObject().encodedLength();
    }

    synchronized void encode(ASN1OutputStream out, boolean withTag) throws IOException
    {
        if (null != encoded)
        {
            out.writeEncoded(withTag, BERTags.SEQUENCE | BERTags.CONSTRUCTED, encoded);
        }
        else
        {
            super.toDLObject().encode(out, withTag);
        }
    }

    synchronized ASN1Primitive toDERObject()
    {
        force();

        return super.toDERObject();
    }

    synchronized ASN1Primitive toDLObject()
    {
        force();

        return super.toDLObject();
    }

<<<<<<< HEAD
    private void force()
    {
        if (null != encoded)
        {
            ASN1EncodableVector v = new ASN1EncodableVector();

            Enumeration en = new LazyConstructionEnumeration(encoded);
            while (en.hasMoreElements())
            {
                v.add((ASN1Primitive)en.nextElement());
            }

            this.elements = v.takeElements();
            this.encoded = null;
        }
=======
    private synchronized void force()
    {
        if (null != encoded)
        {
            ASN1InputStream aIn = new ASN1InputStream(encoded, true);
            try
            {
                ASN1EncodableVector v = aIn.readVector();
                aIn.close();

                this.elements = v.takeElements();
                this.encoded = null;
            }
            catch (IOException e)
            {
                throw new ASN1ParsingException("malformed ASN.1: " + e, e);
            }
        }
    }

    private synchronized byte[] getContents()
    {
        return encoded;
>>>>>>> aosp/upstream-master
    }
}
