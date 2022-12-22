package com.jango.customerrecordorganiser.service;

import com.jango.customerrecordorganiser.dto.BasicResponse;
import com.jango.customerrecordorganiser.dto.ClientRequestDto;

public interface ClientService {

  BasicResponse addClient(ClientRequestDto clientRequest);
  BasicResponse updateClient(ClientRequestDto clientRequest, String clientId);
  BasicResponse getClient(String clientId);
  BasicResponse findAll();
  BasicResponse deleteClient(String clientId);

}
