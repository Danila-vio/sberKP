package com.example.sberServ.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="contracts")
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Date conclusion;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accountsId", nullable = false)
    private Accounts accountsId;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typesId", nullable = false)
    private TypesOfDeposits typesId;

    public Contracts() {
    }

    public Contracts(Integer id, Date conclusion) {
        this.id = id;
        this.conclusion = conclusion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getConclusion() {
        return conclusion;
    }

    public void setConclusion(Date conclusion) {
        this.conclusion = conclusion;
    }

    public Accounts getAccountsId() {
        return accountsId;
    }

    public void setAccountsId(Accounts accountsId) {
        this.accountsId = accountsId;
    }

    public TypesOfDeposits getTypesId() {
        return typesId;
    }

    public void setTypesId(TypesOfDeposits typesId) {
        this.typesId = typesId;
    }
}
