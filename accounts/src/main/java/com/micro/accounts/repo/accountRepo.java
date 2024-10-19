package com.micro.accounts.repo;

import com.micro.accounts.enteties.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface accountRepo extends JpaRepository<account,Integer> {


}
