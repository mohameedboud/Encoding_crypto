package org.sid;

import org.sid.encryption.CryptoUtilImpl;

public class test1 {
    public static void main(String[] args){
        CryptoUtilImpl cryptoUtil=new CryptoUtilImpl();
        String data = "Hello from Crypto >>> ";
        String dataBase64 = cryptoUtil.encodeToBase64(data.getBytes());
        String dataBase64URL = cryptoUtil.encodeToBase64URL(data.getBytes());
        System.out.println(dataBase64);
        System.out.println(dataBase64URL);

        byte[] decodedBytes = cryptoUtil.decodeFromBase64(dataBase64);
        System.out.println(new String(decodedBytes));
        byte[] decodedBytesURL = cryptoUtil.decodeFromBase64URL(dataBase64URL);
        System.out.println(new String(decodedBytesURL));

        /*byte[] dataBytes = data.getBytes();
        System.out.println(Arrays.toString(dataBytes));
        String dataHex = DatatypeConverter.printHexBinary((dataBytes));
        System.out.println(dataHex);
        byte[] bytes = DatatypeConverter.parseHexBinary(dataHex);
        System.out.println(new String(bytes));*/

        String s = cryptoUtil.encodeToHex(data.getBytes());
        String s1 = cryptoUtil.encodeToHexApacheCodec(data.getBytes());
        String s2 = cryptoUtil.encodeToHexNative(data.getBytes());
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
    }
}
