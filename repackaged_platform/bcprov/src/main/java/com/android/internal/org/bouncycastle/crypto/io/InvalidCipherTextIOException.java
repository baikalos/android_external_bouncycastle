/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.internal.org.bouncycastle.crypto.io;

import java.io.IOException;

/**
 * {@link IOException} wrapper around an exception indicating an invalid ciphertext, such as in
 * authentication failure during finalisation of an AEAD cipher. For use in streams that need to
 * expose invalid ciphertext errors.
 * @hide This class is not part of the Android public SDK API
 */
public class InvalidCipherTextIOException
    extends CipherIOException
{
    private static final long serialVersionUID = 1L;

    public InvalidCipherTextIOException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
