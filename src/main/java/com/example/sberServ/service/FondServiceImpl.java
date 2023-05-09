package com.example.sberServ.service;

import com.example.sberServ.interfaces.FondService;
import com.example.sberServ.model.Fond;
import com.example.sberServ.repository.FondRepos;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FondServiceImpl implements FondService {
    private final FondRepos fondRepos;

    public FondServiceImpl(FondRepos fondRepos) {
        this.fondRepos = fondRepos;
    }

    @Transactional
    @Override
    public Fond viewFond() {
        return fondRepos.findById(1).orElse(null);
    }
}
