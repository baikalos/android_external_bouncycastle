/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.org.bouncycastle.operator;

import java.io.IOException;

public class OperatorStreamException
    extends IOException
{
    private Throwable cause;

    public OperatorStreamException(String msg, Throwable cause)
    {
        super(msg);

        this.cause = cause;
    }

    public Throwable getCause()
    {
        return cause; 
    }
}
