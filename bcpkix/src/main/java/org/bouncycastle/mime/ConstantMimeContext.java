<<<<<<< HEAD   (572cf5 Merge "Make bouncycastle-unbundle visible to avf tests" into)
=======
package org.bouncycastle.mime;

import java.io.IOException;
import java.io.InputStream;

public class ConstantMimeContext
    implements MimeContext, MimeMultipartContext
{

    public static final ConstantMimeContext Instance = new ConstantMimeContext();

    public InputStream applyContext(Headers headers, InputStream contentStream)
        throws IOException
    {
        return contentStream;
    }

    public MimeContext createContext(int partNo)
        throws IOException
    {
        return this;
    }
}
>>>>>>> BRANCH (3d1a66 Merge "bouncycastle: Android tree with upstream code for ver)
