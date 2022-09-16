package test;

import pki.bean.CompanyCertificate;
import pki.core.CertificateStore;
import pki.util.Constant;

import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        try{
            /* CompanyCertificate companyCertificate = CertificateStore.getCertificateFromFile(
                    Constant.CERTIFICATE,
                    Constant.PASSWORD);

            System.out.println(companyCertificate.getsAlias());
            System.out.println("---------------------------------------------");
            System.out.println(companyCertificate.getPrivateKey().getAlgorithm());
            System.out.println("---------------------------------------------");
            System.out.println(companyCertificate.getPublicCertificate().toString()); */

            List<CompanyCertificate> companyCertificates = CertificateStore.listCertificatesFromStore();
            for(CompanyCertificate companyCertificate : companyCertificates){
                System.out.println(companyCertificate.getsAlias());
                System.out.println(companyCertificate.getPublicCertificate().getIssuerDN());
                System.out.println(companyCertificate.getPublicCertificate().getNotAfter());
                System.out.println("---------------------------------------------");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
