<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

/**
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public class SupplementalDataEntry
{
    protected int dataType;
    protected byte[] data;

    public SupplementalDataEntry(int dataType, byte[] data)
    {
        this.dataType = dataType;
        this.data = data;
    }

    public int getDataType()
    {
        return dataType;
    }

    public byte[] getData()
    {
        return data;
    }
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
