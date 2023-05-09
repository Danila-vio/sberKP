package com.example.sberServ.service;

import com.example.sberServ.interfaces.AccountsService;
import com.example.sberServ.model.*;
import com.example.sberServ.repository.AccountsRepos;
import com.example.sberServ.repository.ContractsRepos;
import com.example.sberServ.repository.FondRepos;
import com.example.sberServ.repository.TypesOfDepositsRepos;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsService {
    private final AccountsRepos accountsRepos;
    private final TypesOfDepositsRepos typesOfDepositsRepos;
    private final ContractsRepos contractsRepos;
    private final FondRepos fondRepos;

    public AccountsServiceImpl(AccountsRepos accountsRepos, TypesOfDepositsRepos typesOfDepositsRepos, ContractsRepos contractsRepos, FondRepos fondRepos) {
        this.accountsRepos = accountsRepos;
        this.typesOfDepositsRepos = typesOfDepositsRepos;
        this.contractsRepos = contractsRepos;
        this.fondRepos = fondRepos;
    }
    @Transactional
    @Override
    public List<Accounts> allAccountsById(Integer id) {
        Person person = new Person();
        person.setId(id);
        return accountsRepos.findAllByPersonId(person);
    }
    @Transactional
    @Override
    public void createAccounts(Accounts accounts) {
        accounts.setTypesId(typesOfDepositsRepos.findByName(accounts.getTypesId().getName()));
        Contracts contracts = new Contracts();
        contracts.setConclusion(accounts.getStartDeposit());
        contracts.setAccountsId(accountsRepos.save(accounts));
        contracts.setTypesId(accounts.getTypesId());
        contractsRepos.save(contracts);
        if(accounts.getDeposit().equals(Deposits.Refillable)){
            if (accounts.getCurrency().equals(Currency.EUR)){
                fondRepos.update((float) (accounts.getSum()*3.15));
            }else if(accounts.getCurrency().equals(Currency.USD)){
                fondRepos.update((float) (accounts.getSum()*2.87));
            }else if(accounts.getCurrency().equals(Currency.RUB)){
                fondRepos.update((float) (accounts.getSum()*2.7));
            }else {
                fondRepos.update(accounts.getSum().floatValue());
            }
        }else {
            if (accounts.getCurrency().equals(Currency.EUR)){
                fondRepos.update((float) -(accounts.getSum()*3.15));
            }else if(accounts.getCurrency().equals(Currency.USD)){
                fondRepos.update((float) -(accounts.getSum()*2.87));
            }else if(accounts.getCurrency().equals(Currency.RUB)){
                fondRepos.update((float) -(accounts.getSum()*2.7));
            }else {
                fondRepos.update(-accounts.getSum().floatValue());
            }
        }
    }
    @Transactional
    @Override
    public void deleteAccount(Integer id) {
        Accounts accounts = accountsRepos.findById(id).orElse(null);
        if (accounts !=null) {
            if (accounts.getDeposit().equals(Deposits.Refillable)) {
                fondRepos.update(-accounts.getSum().floatValue());
            } else {
                fondRepos.update(accounts.getSum().floatValue());
            }
            accountsRepos.deleteById(id);
        }
    }
    @Transactional
    @Override
    public List<Accounts> getAllAccounts() {
        return accountsRepos.findAll();
    }
    @Transactional
    @Override
    public List<Accounts> closeDay() {
        List<Accounts> list = accountsRepos.findAll();
        list.forEach(accounts -> {
            if(accounts.getDeposit().equals(Deposits.Refillable)){
                accounts.setSum((int) (((accounts.getPercent().floatValue()/100/365)*accounts.getSum())+accounts.getSum()));
            }else {
                accounts.setSum((accounts.getPercent()/100)*accounts.getSum()-accounts.getSum());
            }
        });
        return accountsRepos.saveAll(list);
    }
}
