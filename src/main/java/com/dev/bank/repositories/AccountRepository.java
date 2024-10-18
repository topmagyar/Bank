package com.dev.bank.repositories;

import com.dev.bank.models.dao.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
