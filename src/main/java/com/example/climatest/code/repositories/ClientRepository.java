package com.example.climatest.code.repositories;

import com.example.climatest.code.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}
