package com.micro.loans.repo;

import com.micro.loans.entetites.loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface loansRepo extends JpaRepository<loans,Integer> {
    Optional<loans> findByClientName ( String name ) ;

}
