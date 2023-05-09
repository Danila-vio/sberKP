package com.example.sberServ.service;

import com.example.sberServ.interfaces.TypesOfDepositsService;
import com.example.sberServ.model.TypesOfDeposits;
import com.example.sberServ.repository.TypesOfDepositsRepos;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesOfDepositsServiceImpl implements TypesOfDepositsService {
    private final TypesOfDepositsRepos depositsRepos;

    public TypesOfDepositsServiceImpl(TypesOfDepositsRepos depositsRepos) {
        this.depositsRepos = depositsRepos;
    }
    @Transactional
    @Override
    public List<TypesOfDeposits> getAllTypes() {
        return depositsRepos.findAll();
    }
    @Transactional
    @Override
    public void addNewType(TypesOfDeposits types) {
          depositsRepos.save(types);
    }
}
