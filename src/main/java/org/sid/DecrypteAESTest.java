package org.sid;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DecrypteAESTest {
    public static void main(String[] args) throws Exception {
        String receivedEncryptedData = "aTdsQ2ijTgJydJRWZIZPekqxuF32Pzaaatbwq9cGh9c=";
        byte[] decodeEncryptedData = Base64.getDecoder().decode(receivedEncryptedData);
        String mySecret = "azerty_azerty_az";
        SecretKey secretKey = new SecretKeySpec(mySecret.getBytes(), 0, mySecret.length(), "AES");
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[] decryptedBytes = cipher.doFinal(decodeEncryptedData);
        System.out.println(new String(decryptedBytes));
    }
}
