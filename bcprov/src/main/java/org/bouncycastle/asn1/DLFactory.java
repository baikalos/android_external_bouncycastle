package org.bouncycastle.asn1;

class DLFactory
{
<<<<<<< HEAD
    static final ASN1Sequence EMPTY_SEQUENCE = new DLSequence();
    static final ASN1Set EMPTY_SET = new DLSet();

    static ASN1Sequence createSequence(ASN1EncodableVector v)
=======
    static final DLSequence EMPTY_SEQUENCE = new DLSequence();
    static final DLSet EMPTY_SET = new DLSet();

    static DLSequence createSequence(ASN1EncodableVector v)
>>>>>>> aosp/upstream-master
    {
        if (v.size() < 1)
        {
            return EMPTY_SEQUENCE;
        }

        return new DLSequence(v);
    }

<<<<<<< HEAD
    static ASN1Set createSet(ASN1EncodableVector v)
=======
    static DLSet createSet(ASN1EncodableVector v)
>>>>>>> aosp/upstream-master
    {
        if (v.size() < 1)
        {
            return EMPTY_SET;
        }

        return new DLSet(v);
    }
}
