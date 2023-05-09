package com.example.sberServ.interfaces;

import com.example.sberServ.model.Accounts;

import java.util.List;

public interface AccountsService {
    public List<Accounts> allAccountsById(Integer id);
    public void createAccounts(Accounts accounts);
    public void deleteAccount(Integer id);
    public List<Accounts> getAllAccounts();
    public List<Accounts> closeDay();
}
