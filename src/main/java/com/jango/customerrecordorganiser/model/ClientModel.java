package com.jango.customerrecordorganiser.model;


import com.jango.customerrecordorganiser.config.AesEncryptor;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel  extends BaseModel{

  private String clientId;
  private int age;
  private String name;
  @Convert(converter = AesEncryptor.class)
  private String address;
  @Convert(converter = AesEncryptor.class)
  @Column(unique = true)
  private String email;
  @Convert(converter = AesEncryptor.class)
  @Column(unique = true)
  private String phone;
  @Convert(converter = AesEncryptor.class)
  private String gender;
  @Convert(converter = AesEncryptor.class)
  private String maritalStatus;
  @Convert(converter = AesEncryptor.class)
  private String occupation;
  @Convert(converter = AesEncryptor.class)
  private Double salary;

}
