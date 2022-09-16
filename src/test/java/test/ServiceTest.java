package test;

import pki.bean.CompanyCertificate;
import pki.core.CertificateStore;
import pki.util.Constant;

public class ServiceTest {
    public static void main(String[] args) {
        try{
            CompanyCertificate companyCertificate = CertificateStore.getCertificateFromFile(
                    Constant.CERTIFICATE,
                    Constant.PASSWORD);

            System.out.println(companyCertificate.getsAlias());
            System.out.println("---------------------------------------------");
            System.out.println(companyCertificate.getPrivateKey().getAlgorithm());
            System.out.println("---------------------------------------------");
            System.out.println(companyCertificate.getPublicCertificate().toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
