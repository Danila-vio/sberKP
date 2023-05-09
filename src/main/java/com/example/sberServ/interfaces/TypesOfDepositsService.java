package com.example.sberServ.interfaces;

import com.example.sberServ.model.TypesOfDeposits;

import java.util.List;

public interface TypesOfDepositsService {
    public List<TypesOfDeposits> getAllTypes();
    public void addNewType(TypesOfDeposits types);
}
