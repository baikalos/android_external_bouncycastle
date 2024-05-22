package org.bouncycastle.cms;

import java.io.InputStream;
import java.io.OutputStream;

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
// import org.bouncycastle.operator.InputAEADDecryptor;
=======
import org.bouncycastle.operator.InputAEADDecryptor;
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.util.io.TeeInputStream;

public class RecipientOperator
{
    private final Object operator;

    public RecipientOperator(InputDecryptor decryptor)
    {
        this.operator = decryptor;
    }

    public RecipientOperator(MacCalculator macCalculator)
    {
        this.operator = macCalculator;
    }

    public InputStream getInputStream(InputStream dataIn)
    {
        if (operator instanceof InputDecryptor)
        {
            return ((InputDecryptor)operator).getInputStream(dataIn);
        }
        else
        {
            return new TeeInputStream(dataIn, ((MacCalculator)operator).getOutputStream());
        }
    }

<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
    // BEGIN Android-removed
    /*
    public boolean isAEADBased()
    {
        return operator instanceof InputAEADDecryptor;
    }

    public OutputStream getAADStream()
    {
        return ((InputAEADDecryptor)operator).getAADStream();
    }
    */
    // END Android-removed
=======
    public boolean isAEADBased()
    {
        return operator instanceof InputAEADDecryptor;
    }

    public OutputStream getAADStream()
    {
        return ((InputAEADDecryptor)operator).getAADStream();
    }
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)

    public boolean isMacBased()
    {
        return operator instanceof MacCalculator;
    }

    public byte[] getMac()
    {
        return ((MacCalculator)operator).getMac();
    }
}
