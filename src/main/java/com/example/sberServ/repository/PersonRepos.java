package com.example.sberServ.repository;

import com.example.sberServ.model.City;
import com.example.sberServ.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepos extends JpaRepository<Person, Integer> {
    public Optional<Person> findPersonByLogin(String login);
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Person f set f.name = ?1, f.surname = ?2, f.patronymic=?3, f.city=?4, f.passportNumber=?5,f.identNumber=?6 where f.Id = ?7")
    public void update(String name, String surname, String patronymic, City city,String passportNumber, String identNumber, Integer id);
}
