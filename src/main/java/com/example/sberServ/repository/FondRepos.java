package com.example.sberServ.repository;

import com.example.sberServ.model.Fond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FondRepos extends JpaRepository<Fond,Integer> {
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Fond f set f.capital = f.capital + ?1 where f.id = 1")
    public void update(Float money);
}
