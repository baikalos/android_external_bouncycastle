package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

class StreamUtil
{
<<<<<<< HEAD   (9b30eb Merge "Add core-oj to the list of dependencies")
    // BEGIN android-removed
    // private static final long  MAX_MEMORY = Runtime.getRuntime().maxMemory();
    // END android-removed

    /**
     * Find out possible longest length...
     *
     * @param in input stream of interest
     * @return length calculation or MAX_VALUE.
     */
    static int findLimit(InputStream in)
    {
        if (in instanceof LimitedInputStream)
        {
            return ((LimitedInputStream)in).getRemaining();
        }
        else if (in instanceof ASN1InputStream)
        {
            return ((ASN1InputStream)in).getLimit();
        }
        else if (in instanceof ByteArrayInputStream)
        {
            return ((ByteArrayInputStream)in).available();
        }
        else if (in instanceof FileInputStream)
        {
            try
            {
                FileChannel channel = ((FileInputStream)in).getChannel();
                long  size = (channel != null) ? channel.size() : Integer.MAX_VALUE;

                if (size < Integer.MAX_VALUE)
                {
                    return (int)size;
                }
            }
            catch (IOException e)
            {
                // ignore - they'll find out soon enough!
            }
        }

        // BEGIN android-changed
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        return (int) maxMemory;
        // END android-changed
=======
    private static final long  MAX_MEMORY = Runtime.getRuntime().maxMemory();

    /**
     * Find out possible longest length...
     *
     * @param in input stream of interest
     * @return length calculation or MAX_VALUE.
     */
    static int findLimit(InputStream in)
    {
        if (in instanceof LimitedInputStream)
        {
            return ((LimitedInputStream)in).getRemaining();
        }
        else if (in instanceof ASN1InputStream)
        {
            return ((ASN1InputStream)in).getLimit();
        }
        else if (in instanceof ByteArrayInputStream)
        {
            return ((ByteArrayInputStream)in).available();
        }
        else if (in instanceof FileInputStream)
        {
            try
            {
                FileChannel channel = ((FileInputStream)in).getChannel();
                long  size = (channel != null) ? channel.size() : Integer.MAX_VALUE;

                if (size < Integer.MAX_VALUE)
                {
                    return (int)size;
                }
            }
            catch (IOException e)
            {
                // ignore - they'll find out soon enough!
            }
        }

        if (MAX_MEMORY > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        return (int)MAX_MEMORY;
>>>>>>> BRANCH (7cff05 Merge "bouncycastle: Android tree with upstream code for ver)
    }

    static int calculateBodyLength(
        int length)
    {
        int count = 1;

        if (length > 127)
        {
            int size = 1;
            int val = length;

            while ((val >>>= 8) != 0)
            {
                size++;
            }

            for (int i = (size - 1) * 8; i >= 0; i -= 8)
            {
                count++;
            }
        }

        return count;
    }

    static int calculateTagLength(int tagNo)
        throws IOException
    {
        int length = 1;

        if (tagNo >= 31)
        {
            if (tagNo < 128)
            {
                length++;
            }
            else
            {
                byte[] stack = new byte[5];
                int pos = stack.length;

                stack[--pos] = (byte)(tagNo & 0x7F);

                do
                {
                    tagNo >>= 7;
                    stack[--pos] = (byte)(tagNo & 0x7F | 0x80);
                }
                while (tagNo > 127);

                length += stack.length - pos;
            }
        }

        return length;
    }
}
