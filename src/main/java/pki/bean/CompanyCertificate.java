package pki.bean;

import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class CompanyCertificate {
    private PrivateKey privateKey;
    private Certificate[] certificateChain;
    private String sAlias;
    private X509Certificate publicCertificate;

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public Certificate[] getCertificateChain() {
        return certificateChain;
    }

    public void setCertificateChain(Certificate[] certificateChain) {
        this.certificateChain = certificateChain;
    }

    public String getsAlias() {
        return sAlias;
    }

    public void setsAlias(String sAlias) {
        this.sAlias = sAlias;
    }

    public X509Certificate getPublicCertificate() {
        return publicCertificate;
    }

    public void setPublicCertificate(X509Certificate publicCertificate) {
        this.publicCertificate = publicCertificate;
    }
}
