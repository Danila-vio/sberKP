package com.example.sberServ.model;

import jakarta.persistence.*;

@Entity
@Table(name="fond")
public class Fond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Float capital;

    public Fond() {
    }

    public Fond(Integer id, Float capital) {
        this.id = id;
        this.capital = capital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCapital() {
        return capital;
    }

    public void setCapital(Float capital) {
        this.capital = capital;
    }
}
