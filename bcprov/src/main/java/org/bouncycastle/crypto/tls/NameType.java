<<<<<<< HEAD   (fba1a1 Merge "bouncycastle: add support for PKCS5S2 algorithm param)
=======
package org.bouncycastle.crypto.tls;

public class NameType
{
    /*
     * RFC 3546 3.1.
     */
    public static final short host_name = 0;

    public static boolean isValid(short nameType)
    {
        return nameType == host_name;
    }
}
>>>>>>> BRANCH (eaf604 Merge "bouncycastle: Android tree with upstream code for ver)
