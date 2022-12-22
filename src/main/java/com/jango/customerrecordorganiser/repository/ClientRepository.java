package com.jango.customerrecordorganiser.repository;

import com.jango.customerrecordorganiser.model.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  Optional<Client> findByClientId(String clientId);
}
