package org.sid;

import org.sid.encryption.CryptoUtilImpl;

import java.security.PrivateKey;
import java.security.PublicKey;

public class TestRsaSign {
    public static void main(String[] args) throws Exception {
        CryptoUtilImpl cryptoUtil = new CryptoUtilImpl();
        PrivateKey privateKey= cryptoUtil.privateKeyFromJSK("Med.jks","123456","Med");
        String data = "This is my message";
        String signature = cryptoUtil.rsaSign(data.getBytes(), privateKey);
        String signedDoc = data+"-_-"+signature;
        System.out.println(signedDoc);
        System.out.println(" ======================================= ");
        System.out.println("Signature Verification");
        String signedDocRecieved ="This is my message-_-Opwbt7J8nKrCLURgeqXssrrdTe2l0X38I8P2d8Amo5kNiu6pZTl1HfKhmeYhyycP3DWla44WNKKOi0XM2MfcaBvhLvVeQZKK+PpkhBo2SbY6Vrc193VYDF8BUNCKSTQydCuRC9hlW8sEnORSlLCs1TNLZFINl5RP+jKpA7KrEvT0LcEeKWlRjK1zz3dyU3wPE4FUo8Osf2jz5FwNGrRSlLFJ0VTU7ABuLtymemiMqHsR2GMllBPw8I8whi6CedjkXFaFbSaYiWWZfUiufSw4iPnaUF+SBJQJOZFrunMzgDb9b/AjldJoaLAAu0Eyubsb7PKHPaxVskhL93+SCkRepQ==";
        PublicKey publicKey=cryptoUtil.publicKeyFromCertificate("publickey.cert");
        boolean b = cryptoUtil.rsaSignVerify(signedDocRecieved, publicKey);
        System.out.println(b?"Signature OK":"Signature Not OK");

    }
}
