<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
=======
package org.bouncycastle.cert.crmf;

public class CRMFException
    extends Exception
{
    private Throwable cause;

    public CRMFException(String msg)
    {
        this(msg, null);
    }

    public CRMFException(String msg, Throwable cause)
    {
        super(msg);

        this.cause = cause;
    }

    public Throwable getCause()
    {
        return cause;
    }
}
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
