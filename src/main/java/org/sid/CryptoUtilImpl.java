package org.sid;

import org.apache.commons.codec.binary.Hex;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
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
}
