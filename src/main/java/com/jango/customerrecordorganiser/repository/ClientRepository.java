package com.jango.customerrecordorganiser.repository;


import com.jango.customerrecordorganiser.model.ClientModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

  Optional<ClientModel> findByClientId(String clientId);
}
