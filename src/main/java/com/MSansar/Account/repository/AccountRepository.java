package com.MSansar.Account.repository;

import com.MSansar.Account.model.Account;
import com.MSansar.Account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("Select a from Account a where a.id = :id")
    Account findAccountByUUID(@Param("id")UUID id);
}
