package com.micro.accounts.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.micro.accounts.enteties.client ;

import java.util.Optional;

public interface clientRepo extends JpaRepository<client,Integer> {
     Optional<client> findByName (String name ) ;

}
