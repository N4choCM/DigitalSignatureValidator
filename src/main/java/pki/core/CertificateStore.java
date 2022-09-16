package pki.core;

import pki.bean.CompanyCertificate;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CertificateStore {
    public static CompanyCertificate getCertificateFromFile(String sPath, String sKey){

        CompanyCertificate companyCertificate = new CompanyCertificate();

        try{
            //PKCS12 = Almacena contenido del certificado + clave privada.
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

    public static List<CompanyCertificate> listCertificatesFromStore(){
        List<CompanyCertificate> companyCertificates = new ArrayList<>();

        try{
            KeyStore jks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
            jks.load(null, null);

            Enumeration<String> enumeration = jks.aliases();
            while(enumeration.hasMoreElements()){
                CompanyCertificate companyCertificate = new CompanyCertificate();
                String sKeyAlias = (String) enumeration.nextElement();

                PrivateKey privateKey = (PrivateKey) jks.getKey(sKeyAlias, null);
                Certificate[] certificateChain = jks.getCertificateChain(sKeyAlias);
                X509Certificate publicCertificate = (X509Certificate) certificateChain[0];

                companyCertificate.setsAlias(publicCertificate.getSubjectDN().getName());
                companyCertificate.setPublicCertificate(publicCertificate);
                companyCertificate.setPrivateKey(privateKey);
                companyCertificate.setCertificateChain(certificateChain);

                companyCertificates.add(companyCertificate);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return companyCertificates;
    }
}
