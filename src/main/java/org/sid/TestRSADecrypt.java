package org.sid;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class TestRSADecrypt {
    public static void main(String[] args) throws Exception {

        /*
 Private Key:
MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMkkZFp04fg9PnPUXK7d6cnVNoDr5ffYakarjtVXhA0SDGRjSrnOOSVu4dWnT29rFVNk6xHuCga78roVyD3ECnfgBXoW0VZYs1075i42OKAKEOo9bfVmI4Y8ZXxtLg9F5oRsSfVWN3X71Wb1vb02VcRGeyn/TAjmSWCIOEK67Z3AgMBAAECgYAVXNydsNlJJLQL2EuptN7NTtvMN7BVoZfEByA8yUOwFJ5nQQUPN9b5u1sZDMvGbfvngHLazU8ZtzOP77/NGGKDptxhfRmq0msvGB0H3iKcOZBr2OWx/nl6i51Uzzxs+KnOw/R5hsYFHJYqzn7VDa97sfovMlpniO6bTjdR0XTQJBAPFBK2rqzHi0hucjKdnQX8s2zQn8gfwC7bX5XJrsQgSnX/Dt4iJ9Ce/EuLrAA+4W3EX/n4CXiqqEeeF8v/IM6jMCQQDVb5jFWFJ96qW8aLBEWnBf696uhVmwSyJ9QLvEtJp0OldziDA0P1OQr1qwdQax6ypH8hHv4x04kBFwubZmusatAkBUlxglJezJyeqfMqoi8DgWZcGg5cOh3FkC/EsnGv3O6ezu6knm89a/Fkf7WwZFvghAFvATQ49gWJDvqjEXKsYXAkADFl4rXJ+02pQTKaCDHJvLh2ntNFibyDpzfWA59DLXw5BIR4wK9WMBD1XmBnEsRYnfETuJ2bgzpSyAL22trTxAkEAuvzn+QBU55f1P76u3eCIiViN6Fe87+AMC3lNMM40HZSavXsfqWq8Muaexcb7Yzzf71GUd713iwUTDWke9WzFwg==
Public Key:
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJJGRadOH4PT5z1Fyu3enJ1TaA6+X32GpGq47VV4QNEgxkY0q5zjklbuHVp09vaxVTZOsR7goGu/K6Fcg9xAp34PgV6FtFWWLNdOYuNjigChDqPW31ZiOGPGV8bS4PReaEbEn1Vjd1+9Vm9b29NlXERnsp/0wI5klgiDhCuu2dwIDAQAB
*/


        String privateKeyBase64 ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIzQoYunSabq8Tvg0FPT9CI7hS3bUpGHX+uqc+g/QBNo/wgfJB8YLc2YvBI46Ti+iY4tPnVtqFUhcw50705HtlRqzYu1NS8oy3kTsalP8LENmI8fTm3rCdz7eKV2CDPo21aH3kpHecsiFj+Dl5IHMokW2+fTwiaPHLZipji3iAOBAgMBAAECgYADOeZxmigUVG6pdgmf2gvOWvm+prc6EVVvw0x7hjN0HmQ1be04byfhfX3Vlws02xywrrWvIA+Kv8TwkFpJO1hghti+A0w1oJoXXheE59ep5FGfM3Lu7e/BFqpmd80RXXlAVUDwZN/jVGcx0DTfnACsp7lMWoiqxrlHbrHyqQfuSQJBAOuKljEbAYuR1Tfk+xPEV7U4c14qmnEN3s9MDbXSbWlat81XMiYZlcYZ+rscmHCGEEVKClpnSEm+NlIkvVf0S/0CQQCZC74DQSY6z8RkYuNeQrqzlqnvqZne+NWbrjt6YsIO3q5/qP9wsZXlUOIVK/s6ulcpuWgziIIi62OCwjW6sRLVAkEAtUDwUtl1VvHiIiETFSMCW3IVVWFzd4w06VCdPE2x5GDrEBkJfkgx+UAEsfhPVkfUPX28edUAy76UDqI3EnfsAQJATyMjPcuSWRbWFpKLv1IB+JsPhD3Ost04lyeg2cf3UHkVAi4A5+Tr/Ye1X/0+C0APkiOtHfiYUjYlXpfN8JtfgQJAM95AsXOIYRqg4r2ALw/l9QGy0r9nL+cagefkphNWHg+gifJQ/VEuaQ0NFeiqpM2dL1xHUDYiA/baXh73ZSfuUQ==";
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] decodeKey = Base64.getDecoder().decode(privateKeyBase64);
        PrivateKey privateKey= keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decodeKey));

        String encryptedData = "E0Lw+nb/RlKq/JtHPb83fgey6XbuKufuFSWyCixtQUpdNWSKUoM2O0aPihdhDbFrbg6OFeBxRM+tvsQkohviNKxOTtUz/37oT4WNzLaBDwRUIf8WHn4S5VdKM2bJ923v0y0Wa0scTd+qMRW2vZj8+PD9PZDrYatxp1VkA/LiyNI=";
        System.out.println("Encrypted message: ");
        System.out.println(encryptedData);

        byte[]  decodeEncryptedData = Base64.getDecoder().decode(encryptedData);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(decodeEncryptedData );
        System.out.println("Decrypted message: ");
        System.out.println(new String(decryptedBytes));
     }

}
