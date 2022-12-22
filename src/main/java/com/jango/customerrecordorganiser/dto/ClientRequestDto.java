package com.jango.customerrecordorganiser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

  private int age;
  private String name;
  private String address;
  private String email;
  private String phone;
  private String gender;
  private String maritalStatus;
  private String occupation;
  private Double salary;

}
