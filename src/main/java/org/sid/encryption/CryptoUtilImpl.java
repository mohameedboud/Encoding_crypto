package org.sid.encryption;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Formatter;

public class CryptoUtilImpl {
    public String encodeToBase64(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
    public byte[] decodeFromBase64(String dataBase64){
        return Base64.getDecoder().decode(dataBase64.getBytes());
    }
    public String encodeToBase64URL(byte[] data){
        return Base64.getUrlEncoder().encodeToString(data);
    }
    public byte[] decodeFromBase64URL(String dataBase64){
        return Base64.getUrlDecoder().decode(dataBase64.getBytes());
    }

    public String encodeToHex(byte[] data){
        return DatatypeConverter.printHexBinary(data);
    }

    public String encodeToHexApacheCodec(byte[] data){
        return Hex.encodeHexString(data);
    }

    public String encodeToHexNative(byte[] data){
        Formatter formatter=new Formatter();
        for(byte b:data){
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    public String encryptAES (byte[] data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data);
        String encodedEncryptedData = Base64.getEncoder().encodeToString(encryptedData);
        return encodedEncryptedData ;
    }

    public byte[] decryptAES(String encodedEncryptedData, SecretKey secretKey) throws Exception {
        byte[] decodeEncryptedData = Base64.getDecoder().decode(encodedEncryptedData);
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[] decryptedBytes = cipher.doFinal(decodeEncryptedData);
        return decryptedBytes ;
    }

    public KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }

    public PublicKey publicKeyFromBase64(String pkBase64) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodePK = Base64.getDecoder().decode(pkBase64);
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(decodePK));
        return publicKey ;
    }

    public PrivateKey privateKeyFromBase64(String pkBase64) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodePK = Base64.getDecoder().decode(pkBase64);
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodePK));
        return privateKey ;
    }

    public String encryptRSA(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(data);
        return encodeToBase64(bytes);
    }

    public byte[] decryptRSA(String dataBase64, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedEncrypteData = decodeFromBase64(dataBase64);
        byte[] decryptData = cipher.doFinal(decodedEncrypteData);
        return decryptData;
    }

    public PublicKey publicKeyFromCertificate(String fileName) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        Certificate certificate =certificateFactory.generateCertificate(fileInputStream);
        System.out.println(" ========================================== ");
        System.out.println(certificate.toString());
        System.out.println(" ========================================== ");
        return certificate.getPublicKey();
    }

    public PrivateKey privateKeyFromJSK(String fileName, String jksPassWord, String alias) throws Exception {
        FileInputStream fileInputStream= new FileInputStream(fileName);
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(fileInputStream, jksPassWord.toCharArray());
        Key key =keyStore.getKey(alias, jksPassWord.toCharArray());
        PrivateKey privateKey = (PrivateKey) key ;
        return privateKey ;
    }
}
