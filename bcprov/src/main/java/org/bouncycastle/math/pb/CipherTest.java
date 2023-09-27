package org.bouncycastle.math.pb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import javax.crypto.Cipher;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

public final class CipherTest {
    /**
     * http://b/27224566
     * http://b/27994930
     * Check that a PBKDF2WITHHMACSHA1 secret key factory works well with a
     * PBEWITHSHAAND128BITAES-CBC-BC cipher. The former is PKCS5 and the latter is PKCS12, and so
     * mixing them is not recommended.
     */
    public void test_PBKDF2WITHHMACSHA1_SKFactory_and_PBEAESCBC_Cipher_noIV() throws Exception {
        Assume.assumeNotNull(Security.getProvider("BC"));
        byte[] plaintext = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19 };
        byte[] ciphertext = new byte[] {  92, -65, -128, 16, -102, -115, -44, 52, 16, 124, -34,
                -45, 58, -70, -17, 127, 119, -67, 87, 91, 63, -13, -40, 9, 97, -17, -71, 97, 10,
                -61, -19, -73 };
        SecretKeyFactory skf =
                SecretKeyFactory.getInstance("PBKDF2WITHHMACSHA1");
        PBEKeySpec pbeks = new PBEKeySpec("password".toCharArray(),
                "salt".getBytes(TestUtils.UTF_8),
                100, 128);
        SecretKey secretKey = skf.generateSecret(pbeks);

        Cipher cipher =
                Cipher.getInstance("PBEWITHSHAAND128BITAES-CBC-BC");
        PBEParameterSpec paramSpec = new PBEParameterSpec("salt".getBytes(TestUtils.UTF_8), 100);
        assertThrows(InvalidAlgorithmParameterException.class,
                () -> cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec));
    }

    /**
     * http://b/27224566
     * http://b/27994930
     * Check that a PBKDF2WITHHMACSHA1 secret key factory works well with a
     * PBEWITHSHAAND128BITAES-CBC-BC cipher. The former is PKCS5 and the latter is PKCS12, and so
     * mixing them is not recommended. However, until 1.52 BouncyCastle was accepting this mixture,
     * assuming the IV was a 0 vector. Some apps still use this functionality. This
     * compatibility is likely to be removed in later versions of Android.
     * TODO(27995180): consider whether we keep this compatibility. Consider whether we only allow
     * if an IV is passed in the parameters.
     */
    public void test_PBKDF2WITHHMACSHA1_SKFactory_and_PBEAESCBC_Cipher_withIV() throws Exception {
        Assume.assumeNotNull(Security.getProvider("BC"));
        byte[] plaintext = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,  12, 13, 14, 15, 16,
                17, 18, 19 };
        byte[] ciphertext = { 68, -87, 71, -6, 32, -77, 124, 3, 35, -26, 96, -16, 100, -17, 52, -32,
                110, 26, -117, 112, -25, -113, -58, -30, 19, -46, -21, 59, -126, -8, -70, -89 };
        byte[] iv = new byte[] { 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        SecretKeyFactory skf =
                SecretKeyFactory.getInstance("PBKDF2WITHHMACSHA1");
        PBEKeySpec pbeks = new PBEKeySpec("password".toCharArray(),
                "salt".getBytes(TestUtils.UTF_8),
                100, 128);
        SecretKey secretKey = skf.generateSecret(pbeks);
        Cipher cipher =
                Cipher.getInstance("PBEWITHSHAAND128BITAES-CBC-BC");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        assertEquals(Arrays.toString(ciphertext), Arrays.toString(cipher.doFinal(plaintext)));

        secretKey = skf.generateSecret(pbeks);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        assertEquals(Arrays.toString(plaintext), Arrays.toString(cipher.doFinal(ciphertext)));
    }
}