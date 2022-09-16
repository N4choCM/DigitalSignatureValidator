package pki.core;

import pki.bean.CompanyCertificate;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class CertificateStore {
    public static CompanyCertificate getCertificateFromFile(String sPath, String sKey){

        CompanyCertificate companyCertificate = new CompanyCertificate();

        try{
            KeyStore jks = KeyStore.getInstance("PKCS12");
            InputStream in = new FileInputStream(sPath);
            jks.load(in, sKey.toCharArray());
            in.close();

            String sJksAlias = jks.aliases().nextElement();
            PrivateKey privateKey = (PrivateKey) jks.getKey(sJksAlias, sKey.toCharArray());
            Certificate[] certificateChain = jks.getCertificateChain(sJksAlias);
            X509Certificate publicCertificate = (X509Certificate) certificateChain[0];

            companyCertificate.setsAlias(publicCertificate.getSubjectDN().getName());
            companyCertificate.setPublicCertificate(publicCertificate);
            companyCertificate.setPrivateKey(privateKey);
            companyCertificate.setCertificateChain(certificateChain);

        }catch (Exception e){
            e.printStackTrace();
        }

        return companyCertificate;
    }
}
