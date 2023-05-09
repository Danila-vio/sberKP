package com.example.sberServ.service;

import com.example.sberServ.interfaces.ContractsService;
import com.example.sberServ.model.Accounts;
import com.example.sberServ.model.Contracts;
import com.example.sberServ.model.Person;
import com.example.sberServ.repository.ContractsRepos;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractsServiceImpl implements ContractsService {
    private final ContractsRepos contractsRepos;

    public ContractsServiceImpl(ContractsRepos contractsRepos) {
        this.contractsRepos = contractsRepos;
    }
    @Transactional
    @Override
    public List<Contracts> allContractsByPersonId(Integer id) {
        Person person = new Person();
        person.setId(id);
        Accounts accounts = new Accounts();
        accounts.setPersonId(person);
        return contractsRepos.findAllByAccountsId_PersonId_Id(id);
    }
    @Transactional
    @Override
    public List<Contracts> getAllContracts() {
        return contractsRepos.findAll();
    }
}
