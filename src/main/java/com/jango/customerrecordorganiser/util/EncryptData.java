package com.jango.customerrecordorganiser.util;

import javax.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Autowired;

public class EncryptData implements AttributeConverter<String,String> {

  @Autowired
  EncryptionUtil encryptionUtil;

  @Override
  public String convertToDatabaseColumn(String s) {
    return encryptionUtil.encrypt(s);
  }

  @Override
  public String convertToEntityAttribute(String s) {
    return encryptionUtil.decrypt(s);
  }

}
