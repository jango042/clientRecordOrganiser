package com.jango.customerrecordorganiser.model;


import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseModel {

  private String clientId;
  private int age;
  private String name;
  @Convert(converter = EncryptData.class)
  private String address;
  @Convert(converter = EncryptData.class)
  private String email;
  private String phone;
  @Convert(converter = EncryptData.class)
  private String gender;
  @Convert(converter = EncryptData.class)
  private String maritalStatus;
  @Convert(converter = EncryptData.class)
  private String occupation;
  @Convert(converter = EncryptData.class)
  private Double salary;

}
