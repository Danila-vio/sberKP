package com.example.sberServ.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="typesOfAccounts")
public class TypesOfDeposits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(unique = true)
    private Integer number;
    @Enumerated(EnumType.STRING)
    private Activity activity;
    private String name;
    @OneToMany(mappedBy = "typesId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Accounts> typesId;
    @OneToOne(mappedBy = "typesId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Contracts contractsId;

    public TypesOfDeposits() {
    }

    public TypesOfDeposits(Integer id, Integer number, Activity activity, String name) {
        this.id = id;
        this.number = number;
        this.activity = activity;
        this.name = name;
    }

    public Contracts getContractsId() {
        return contractsId;
    }

    public void setContractsId(Contracts contractsId) {
        this.contractsId = contractsId;
    }

    public Set<Accounts> getTypesId() {
        return typesId;
    }

    public void setTypesId(Set<Accounts> typesId) {
        this.typesId = typesId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
