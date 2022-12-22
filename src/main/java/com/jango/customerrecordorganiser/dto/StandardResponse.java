package com.jango.customerrecordorganiser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jango.customerrecordorganiser.enums.Status;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse implements Serializable {

  @JsonProperty
  protected Status status;

}
