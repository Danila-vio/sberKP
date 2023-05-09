package com.example.sberServ.repository;

import com.example.sberServ.model.Accounts;
import com.example.sberServ.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepos extends JpaRepository<Accounts,Integer> {
    public List<Accounts> findAllByPersonId(Person personId);
}
