package com.jango.customerrecordorganiser.service.impl;

import com.jango.customerrecordorganiser.dto.BasicResponse;
import com.jango.customerrecordorganiser.dto.ClientRequestDto;
import com.jango.customerrecordorganiser.enums.Status;
import com.jango.customerrecordorganiser.model.ClientModel;
import com.jango.customerrecordorganiser.repository.ClientRepository;
import com.jango.customerrecordorganiser.service.ClientService;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

  private static final String NOT_FOUND_MESSAGE = "Id provided not found";
  private final ClientRepository clientRepository;
  private final ModelMapper modelMapper;

  @Override
  public BasicResponse addClient(ClientRequestDto clientRequest) {
    ClientModel clientModel = modelMapper.map(clientRequest, ClientModel.class);
    clientModel.setClientId(UUID.randomUUID().toString());
    ClientModel mClientModel = clientRepository.save(clientModel);
    return new BasicResponse(Status.CREATED, mClientModel);
  }

  @Override
  public BasicResponse updateClient(ClientRequestDto clientRequest, String clientId) {
    return clientRepository.findByClientId(clientId).map(client -> {
      client.setAddress(clientRequest.getAddress());
      client.setAge(clientRequest.getAge());
      client.setEmail(clientRequest.getEmail());
      client.setGender(clientRequest.getGender());
      client.setMaritalStatus(clientRequest.getMaritalStatus());
      client.setName(clientRequest.getName());
      client.setOccupation(clientRequest.getOccupation());
      client.setPhone(clientRequest.getPhone());
      client.setSalary(clientRequest.getSalary());
      client.setUpdatedAt(LocalDateTime.now());
      clientRepository.save(client);
      return new BasicResponse(Status.SUCCESS, "Updated Successfully");
    }).orElse(new BasicResponse(Status.NOT_FOUND, NOT_FOUND_MESSAGE));

  }

  @Override
  public BasicResponse getClient(String clientId) {
    Optional<ClientModel> client = clientRepository.findByClientId(clientId);
    return client.map(value -> new BasicResponse(Status.SUCCESS, value))
        .orElseGet(() -> new BasicResponse(Status.NOT_FOUND, NOT_FOUND_MESSAGE));
  }

  @Override
  public BasicResponse findAll() {
    return new BasicResponse(Status.SUCCESS, clientRepository.findAll());
  }

  @Override
  public BasicResponse deleteClient(String clientId) {
    Optional<ClientModel> client = clientRepository.findByClientId(clientId);
    if (client.isPresent()) {
      clientRepository.delete(client.get());
      return new BasicResponse(Status.SUCCESS, "Client with Id "+clientId+" deleted successfully");
    } else {
      return new BasicResponse(Status.NOT_FOUND, NOT_FOUND_MESSAGE);
    }
  }
}
