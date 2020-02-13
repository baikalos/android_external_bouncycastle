<<<<<<< HEAD   (fc2c71 Merge "Match ciphers by exact mode name")
=======
package org.bouncycastle.cert.path.validations;

import java.math.BigInteger;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.PolicyConstraints;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidation;
import org.bouncycastle.cert.path.CertPathValidationContext;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.Memoable;

public class CertificatePoliciesValidation
    implements CertPathValidation
{
    private int              explicitPolicy;
    private int              policyMapping;
    private int              inhibitAnyPolicy;

    CertificatePoliciesValidation(int pathLength)
    {
        this(pathLength, false, false, false);
    }

    CertificatePoliciesValidation(int pathLength, boolean isExplicitPolicyRequired, boolean isAnyPolicyInhibited, boolean isPolicyMappingInhibited)
    {
        //
        // (d)
        //

        if (isExplicitPolicyRequired)
        {
            explicitPolicy = 0;
        }
        else
        {
            explicitPolicy = pathLength + 1;
        }

        //
        // (e)
        //
        if (isAnyPolicyInhibited)
        {
            inhibitAnyPolicy = 0;
        }
        else
        {
            inhibitAnyPolicy = pathLength + 1;
        }

        //
        // (f)
        //
        if (isPolicyMappingInhibited)
        {
            policyMapping = 0;
        }
        else
        {
            policyMapping = pathLength + 1;
        }
    }

    public void validate(CertPathValidationContext context, X509CertificateHolder certificate)
        throws CertPathValidationException
    {
        context.addHandledExtension(Extension.policyConstraints);
        context.addHandledExtension(Extension.inhibitAnyPolicy);

        if (!context.isEndEntity())
        {
            if (!ValidationUtils.isSelfIssued(certificate))
            {
                 //
                // H (1), (2), (3)
                //
                explicitPolicy = countDown(explicitPolicy);
                policyMapping = countDown(policyMapping);
                inhibitAnyPolicy = countDown(inhibitAnyPolicy);

                //
                // I (1), (2)
                //
                PolicyConstraints policyConstraints = PolicyConstraints.fromExtensions(certificate.getExtensions());

                if (policyConstraints != null)
                {
                    BigInteger requireExplicitPolicyMapping = policyConstraints.getRequireExplicitPolicyMapping();
                    if (requireExplicitPolicyMapping != null)
                    {
                        if (requireExplicitPolicyMapping.intValue() < explicitPolicy)
                        {
                            explicitPolicy = requireExplicitPolicyMapping.intValue();
                        }
                    }

                    BigInteger inhibitPolicyMapping = policyConstraints.getInhibitPolicyMapping();
                    if (inhibitPolicyMapping != null)
                    {
                        if (inhibitPolicyMapping.intValue() < policyMapping)
                        {
                            policyMapping = inhibitPolicyMapping.intValue();
                        }
                    }
                }

                //
                // J
                //
                Extension ext = certificate.getExtension(Extension.inhibitAnyPolicy);

                if (ext != null)
                {
                    int extValue = ASN1Integer.getInstance(ext.getParsedValue()).intValueExact();

                    if (extValue < inhibitAnyPolicy)
                    {
                        inhibitAnyPolicy = extValue;
                    }
                }
            }
        }
    }

    private int countDown(int policyCounter)
    {
        if (policyCounter != 0)
        {
            return policyCounter - 1;
        }

        return 0;
    }

    public Memoable copy()
    {
        return new CertificatePoliciesValidation(0);    // TODO:
    }

    public void reset(Memoable other)
    {
        CertificatePoliciesValidation v = (CertificatePoliciesValidation)other;      // TODO:
    }
}
>>>>>>> BRANCH (20d025 Merge "bouncycastle: Android tree with upstream code for ver)
