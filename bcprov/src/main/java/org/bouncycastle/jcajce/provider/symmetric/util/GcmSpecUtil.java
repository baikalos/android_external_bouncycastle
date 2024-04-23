package org.bouncycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

import org.bouncycastle.asn1.ASN1Primitive;
<<<<<<< HEAD
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
=======
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.internal.asn1.cms.GCMParameters;
>>>>>>> aosp/upstream-master
import org.bouncycastle.util.Integers;

public class GcmSpecUtil
{
<<<<<<< HEAD
    static final Class gcmSpecClass = ClassUtil.loadClass(GcmSpecUtil.class, "javax.crypto.spec.GCMParameterSpec");

    static final Method tLen;
    static final Method iv;

    static
    {
        if (gcmSpecClass != null)
        {
=======
    static final Class gcmSpecClass;
    private static final Constructor constructor;
    private static final Method tLen;
    private static final Method iv;

    static
    {
        gcmSpecClass = ClassUtil.loadClass(GcmSpecUtil.class, "javax.crypto.spec.GCMParameterSpec");

        if (gcmSpecClass != null)
        {
            constructor = extractConstructor();
>>>>>>> aosp/upstream-master
            tLen = extractMethod("getTLen");
            iv = extractMethod("getIV");
        }
        else
        {
<<<<<<< HEAD
=======
            constructor = null;
>>>>>>> aosp/upstream-master
            tLen = null;
            iv = null;
        }
    }

<<<<<<< HEAD
=======
    private static Constructor extractConstructor()
    {
        try
        {
            return (Constructor)AccessController.doPrivileged(new PrivilegedExceptionAction()
            {
                public Object run()
                    throws Exception
                {
                    return gcmSpecClass.getConstructor(new Class[]{ Integer.TYPE, byte[].class });
                }
            });
        }
        catch (PrivilegedActionException e)
        {
            return null;
        }
    }

>>>>>>> aosp/upstream-master
    private static Method extractMethod(final String name)
    {
        try
        {
            return (Method)AccessController.doPrivileged(new PrivilegedExceptionAction()
            {
                public Object run()
                    throws Exception
                {
                    return gcmSpecClass.getDeclaredMethod(name, new Class[0]);
                }
            });
        }
        catch (PrivilegedActionException e)
        {
            return null;
        }
    }

    public static boolean gcmSpecExists()
    {
        return gcmSpecClass != null;
    }

<<<<<<< HEAD
=======
    public static boolean gcmSpecExtractable()
    {
        return constructor != null;
    }

>>>>>>> aosp/upstream-master
    public static boolean isGcmSpec(AlgorithmParameterSpec paramSpec)
    {
        return gcmSpecClass != null && gcmSpecClass.isInstance(paramSpec);
    }

    public static boolean isGcmSpec(Class paramSpecClass)
    {
        return gcmSpecClass == paramSpecClass;
    }

    public static AlgorithmParameterSpec extractGcmSpec(ASN1Primitive spec)
        throws InvalidParameterSpecException
    {
        try
        {
            GCMParameters gcmParams = GCMParameters.getInstance(spec);
<<<<<<< HEAD
            Constructor constructor = gcmSpecClass.getConstructor(new Class[]{Integer.TYPE, byte[].class});

            return (AlgorithmParameterSpec)constructor.newInstance(new Object[] { Integers.valueOf(gcmParams.getIcvLen() * 8), gcmParams.getNonce() });
        }
        catch (NoSuchMethodException e)
        {
            throw new InvalidParameterSpecException("No constructor found!");   // should never happen
        }
=======

            return (AlgorithmParameterSpec)constructor.newInstance(new Object[] { Integers.valueOf(gcmParams.getIcvLen() * 8), gcmParams.getNonce() });
        }
>>>>>>> aosp/upstream-master
        catch (Exception e)
        {
            throw new InvalidParameterSpecException("Construction failed: " + e.getMessage());   // should never happen
        }
    }

    static AEADParameters extractAeadParameters(final KeyParameter keyParam, final AlgorithmParameterSpec params)
        throws InvalidAlgorithmParameterException
    {
        try
        {
            return (AEADParameters)AccessController.doPrivileged(new PrivilegedExceptionAction()
            {
                public Object run()
                    throws Exception
                {
                    return new AEADParameters(keyParam, ((Integer)tLen.invoke(params, new Object[0])).intValue(), (byte[])iv.invoke(params, new Object[0]));
                }
            });
        }
        catch (Exception e)
        {
            throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
        }
    }

    public static GCMParameters extractGcmParameters(final AlgorithmParameterSpec paramSpec)
        throws InvalidParameterSpecException
    {
        try
        {
            return (GCMParameters)AccessController.doPrivileged(new PrivilegedExceptionAction()
            {
                public Object run()
                    throws Exception
                {
                    return new GCMParameters((byte[])iv.invoke(paramSpec, new Object[0]), ((Integer)tLen.invoke(paramSpec, new Object[0])).intValue() / 8);
                }
            });
        }
        catch (Exception e)
        {
            throw new InvalidParameterSpecException("Cannot process GCMParameterSpec");
        }
    }
}
