package com.jango.customerrecordorganiser.controller;

import com.jango.customerrecordorganiser.dto.BasicResponse;
import com.jango.customerrecordorganiser.dto.ClientRequestDto;
import com.jango.customerrecordorganiser.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClientController {

  private final ClientService clientService;



  @PostMapping("/")
  public BasicResponse createClient(@RequestBody ClientRequestDto clientRequest) {
    return clientService.addClient(clientRequest);
  }

  @GetMapping("/{clientId}")
  public BasicResponse getSingleClient(@PathVariable("clientId") String clientId) {
    return clientService.getClient(clientId);
  }

  @GetMapping("/")
  public BasicResponse getAllClient() {
    return clientService.findAll();
  }

  @PutMapping("/{clientId}")
  public BasicResponse updateClient(@RequestBody ClientRequestDto clientRequest, @PathVariable("clientId") String clientId) {
    return clientService.updateClient(clientRequest, clientId);
  }

  @DeleteMapping("/{clientId}")
  public BasicResponse deleteClient(@PathVariable("clientId") String clientId) {
    return clientService.deleteClient(clientId);
  }

}
