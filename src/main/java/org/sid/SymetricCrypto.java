package org.sid;

import org.sid.encryption.CryptoUtilImpl;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class SymetricCrypto {
    public static void main(String[] args) throws Exception{
        CryptoUtilImpl cryptoUtil = new CryptoUtilImpl();
        SecretKey secretKey = cryptoUtil.generateSecretKey();
        byte[] secretKeyBytes = secretKey.getEncoded();
        System.out.println(Arrays.toString(secretKeyBytes));
        String encodedSecretKey = Base64.getEncoder().encodeToString(secretKeyBytes);
        System.out.println(encodedSecretKey);
        System.out.println(" ====================================== ");
        String data = "My data ... ";
        String encryptedData = cryptoUtil.encryptAES(data.getBytes(), secretKey);
        System.out.println(encryptedData);
        byte[] decryptedBytes = cryptoUtil.decryptAES(encryptedData, secretKey);
        System.out.println(new String(decryptedBytes));
    }
}
