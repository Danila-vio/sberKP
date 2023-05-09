package com.example.sberServ.service;

import com.example.sberServ.Encoder.PasswordEncoder;
import com.example.sberServ.interfaces.AuthService;
import com.example.sberServ.model.Person;
import com.example.sberServ.repository.PersonRepos;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final PersonRepos personRepos;

    public AuthServiceImpl(PersonRepos personRepos) {
        this.personRepos = personRepos;
    }

    @Transactional
    @Override
    public Person auth(Person person){
        Person pers = personRepos.findPersonByLogin(person.getLogin()).orElse(null);
        if(pers != null){
            if(PasswordEncoder.HashPassword(person.getPassword()).equals(pers.getPassword())){
                return pers;
        }else return new Person();
        }else return  new Person();
    }
}
