package com.example.sberServ.repository;

import com.example.sberServ.model.TypesOfDeposits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypesOfDepositsRepos extends JpaRepository<TypesOfDeposits,Integer> {
    public TypesOfDeposits findByName(String name);
}
