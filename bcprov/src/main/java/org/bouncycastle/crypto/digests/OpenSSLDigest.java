/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Digest;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Implements the BouncyCastle Digest interface using OpenSSL's EVP API.
 */
public class OpenSSLDigest implements Digest {
    private final MessageDigest delegate;

    public OpenSSLDigest(String algorithm) {
        try {
            delegate = MessageDigest.getInstance(algorithm, "AndroidOpenSSL");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getAlgorithmName() {
        return delegate.getAlgorithm();
    }

    public int getDigestSize() {
        return delegate.getDigestLength();
    }

    public void reset() {
        delegate.reset();
    }

    public void update(byte in) {
        delegate.update(in);
    }

    public void update(byte[] in, int inOff, int len) {
        delegate.update(in, inOff, len);
    }

    public int doFinal(byte[] out, int outOff) {
        try {
            return delegate.digest(out, outOff, out.length);
        } catch (DigestException e) {
            throw new RuntimeException(e);
        }
    }

    public static class MD5 extends OpenSSLDigest {
        public MD5() { super("MD5"); }
    }

    public static class SHA1 extends OpenSSLDigest {
        public SHA1() { super("SHA-1"); }
    }

    public static class SHA224 extends OpenSSLDigest {
        public SHA224() { super("SHA-224"); }
    }

    public static class SHA256 extends OpenSSLDigest {
        public SHA256() { super("SHA-256"); }
    }

    public static class SHA384 extends OpenSSLDigest {
        public SHA384() { super("SHA-384"); }
    }

    public static class SHA512 extends OpenSSLDigest {
        public SHA512() { super("SHA-512"); }
    }
}
