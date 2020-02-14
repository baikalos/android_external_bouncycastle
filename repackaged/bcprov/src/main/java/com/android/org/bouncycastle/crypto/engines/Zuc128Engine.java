/* GENERATED SOURCE. DO NOT MODIFY. */
package com.android.org.bouncycastle.crypto.engines;

import com.android.org.bouncycastle.util.Memoable;

/**
 * Zuc256 implementation.
 * Based on http://www.is.cas.cn/ztzl2016/zouchongzhi/201801/W020180126529970733243.pdf
 * @hide This class is not part of the Android public SDK API
 */
public final class Zuc128Engine
    extends Zuc128CoreEngine
{
    /**
     * Constructor for streamCipher.
     */
    public Zuc128Engine()
    {
        super();
    }

    /**
     * Constructor for Memoable.
     *
     * @param pSource the source engine
     */
    private Zuc128Engine(final Zuc128Engine pSource)
    {
        super(pSource);
    }

    /**
     * Create a copy of the engine.
     *
     * @return the copy
     */
    public Memoable copy()
    {
        return new Zuc128Engine(this);
    }
}
