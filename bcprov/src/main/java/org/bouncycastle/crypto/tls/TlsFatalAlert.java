<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
=======
package org.bouncycastle.crypto.tls;

public class TlsFatalAlert
    extends TlsException
{
    protected short alertDescription;

    public TlsFatalAlert(short alertDescription)
    {
        this(alertDescription, null);
    }

    public TlsFatalAlert(short alertDescription, Throwable alertCause)
    {
        super(AlertDescription.getText(alertDescription), alertCause);

        this.alertDescription = alertDescription;
    }

    public short getAlertDescription()
    {
        return alertDescription;
    }
}
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
