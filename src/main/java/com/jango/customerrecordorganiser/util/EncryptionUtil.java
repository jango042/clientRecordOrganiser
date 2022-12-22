package com.jango.customerrecordorganiser.util;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;

public class EncryptionUtil {

  @Value("${cypher.key}")
  private String key;
  @Value("${cypher.initvector}")
  private String initVector;
  @Value("${cypher.algo}")
  private String algo;


  public String encrypt(String value) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

      Cipher cipher = Cipher.getInstance(algo);
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

      byte[] encrypted = cipher.doFinal(value.getBytes());
      return Base64.encodeBase64String(encrypted);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }

  public String decrypt(String encrypted) {
    try {
      IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
      SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

      Cipher cipher = Cipher.getInstance(algo);
      cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

      byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
      return new String(original);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }


}
