package com.jango.customerrecordorganiser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jango.customerrecordorganiser.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponse extends StandardResponse {

  @JsonProperty
  private Object responseData;

  public BasicResponse(Status status) {
    super(status);
  }

  public BasicResponse(Status status, Object responseData) {
    super(status);
    this.responseData = responseData;
  }

}
