package com.example.sberServ.repository;

import com.example.sberServ.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractsRepos extends JpaRepository<Contracts,Integer> {
    public List<Contracts> findAllByAccountsId_PersonId_Id(Integer accounts);
}
