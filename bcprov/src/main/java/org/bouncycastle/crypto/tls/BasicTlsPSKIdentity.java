<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.crypto.tls;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/**
 * @deprecated Migrate to the (D)TLS API in org.bouncycastle.tls (bctls jar).
 */
public class BasicTlsPSKIdentity
    implements TlsPSKIdentity
{
    protected byte[] identity;
    protected byte[] psk;

    public BasicTlsPSKIdentity(byte[] identity, byte[] psk)
    {
        this.identity = Arrays.clone(identity);
        this.psk = Arrays.clone(psk);
    }

    public BasicTlsPSKIdentity(String identity, byte[] psk)
    {
        this.identity = Strings.toUTF8ByteArray(identity);
        this.psk = Arrays.clone(psk);
    }

    public void skipIdentityHint()
    {
    }

    public void notifyIdentityHint(byte[] psk_identity_hint)
    {
    }

    public byte[] getPSKIdentity()
    {
        return identity;
    }

    public byte[] getPSK()
    {
        return Arrays.clone(psk);
    }
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
