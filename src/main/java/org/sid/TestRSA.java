package org.sid;

import org.sid.encryption.CryptoUtilImpl;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class TestRSA {
    public static void main(String[] args) throws Exception{

        /*
 Private Key:
MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMkkZFp04fg9PnPUXK7d6cnVNoDr5ffYakarjtVXhA0SDGRjSrnOOSVu4dWnT29rFVNk6xHuCga78roVyD3ECnfgBXoW0VZYs1075i42OKAKEOo9bfVmI4Y8ZXxtLg9F5oRsSfVWN3X71Wb1vb02VcRGeyn/TAjmSWCIOEK67Z3AgMBAAECgYAVXNydsNlJJLQL2EuptN7NTtvMN7BVoZfEByA8yUOwFJ5nQQUPN9b5u1sZDMvGbfvngHLazU8ZtzOP77/NGGKDptxhfRmq0msvGB0H3iKcOZBr2OWx/nl6i51Uzzxs+KnOw/R5hsYFHJYqzn7VDa97sfovMlpniO6bTjdR0XTQJBAPFBK2rqzHi0hucjKdnQX8s2zQn8gfwC7bX5XJrsQgSnX/Dt4iJ9Ce/EuLrAA+4W3EX/n4CXiqqEeeF8v/IM6jMCQQDVb5jFWFJ96qW8aLBEWnBf696uhVmwSyJ9QLvEtJp0OldziDA0P1OQr1qwdQax6ypH8hHv4x04kBFwubZmusatAkBUlxglJezJyeqfMqoi8DgWZcGg5cOh3FkC/EsnGv3O6ezu6knm89a/Fkf7WwZFvghAFvATQ49gWJDvqjEXKsYXAkADFl4rXJ+02pQTKaCDHJvLh2ntNFibyDpzfWA59DLXw5BIR4wK9WMBD1XmBnEsRYnfETuJ2bgzpSyAL22trTxAkEAuvzn+QBU55f1P76u3eCIiViN6Fe87+AMC3lNMM40HZSavXsfqWq8Muaexcb7Yzzf71GUd713iwUTDWke9WzFwg==
Public Key:
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJJGRadOH4PT5z1Fyu3enJ1TaA6+X32GpGq47VV4QNEgxkY0q5zjklbuHVp09vaxVTZOsR7goGu/K6Fcg9xAp34PgV6FtFWWLNdOYuNjigChDqPW31ZiOGPGV8bS4PReaEbEn1Vjd1+9Vm9b29NlXERnsp/0wI5klgiDhCuu2dwIDAQAB

         */

        String publicKeyBase64 ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDAjXWnJJ71A4pCbVY8SuXBpEiDJ7bYUZvrTS/tbwyJmyUqaTaDXGq5XkLjS00CDfcEKLh7n2LJkp7zAHIDzbe5d8vFiXIWOViXSBj08pBi1HmXvNDGk4rRYsa1ASSAiqfmYBAnw3MCrWFojSs9ectuwfqsv1xoGhMf7H1IBB9jKQIDAQAB";
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodeKey = Base64.getDecoder().decode(publicKeyBase64);
        PublicKey publicKey= keyFactory.generatePublic(new X509EncodedKeySpec(decodeKey));

        String data = "Voici mon message clair à chiffrer ";
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        System.out.println("Encrypted message: ");
        System.out.println(Base64.getEncoder().encodeToString(encryptedBytes));
     }
}
