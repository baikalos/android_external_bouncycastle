<<<<<<< HEAD   (bdfb20 Merge "Fix the spelling error in ReasonsMask")
=======
package org.bouncycastle.pkcs.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests
    extends TestCase
{
    public static void main (String[] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite()
    {
        TestSuite suite = new TestSuite("PKCS Tests");
        
        suite.addTestSuite(PfxPduTest.class);
        suite.addTestSuite(PKCS10Test.class);
        suite.addTestSuite(PKCS8Test.class);

        return new BCTestSetup(suite);
    }
}
>>>>>>> BRANCH (1b335c Merge "bouncycastle: Android tree with upstream code for ver)
