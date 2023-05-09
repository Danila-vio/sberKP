package com.example.sberServ.interfaces;

import com.example.sberServ.model.Contracts;

import java.util.List;

public interface ContractsService {
    public List<Contracts> allContractsByPersonId(Integer id);
    public List<Contracts> getAllContracts();
}
