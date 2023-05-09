package com.example.sberServ.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personId", nullable = false)
    private Person personId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typesId", nullable = false)
    private TypesOfDeposits typesId;
    @Enumerated(EnumType.STRING)
    private Deposits deposit;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Date startDeposit;
    private Date endDeposit;
    private Integer sum;
    private Integer percent;

    @OneToOne(mappedBy = "accountsId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Contracts contractsId;

    public Accounts() {
    }

    public Accounts(Integer id, Person personId, TypesOfDeposits types, Deposits deposit, Currency currency, Date startDeposit, Date endDeposit, Integer sum, Integer percent) {
        this.id = id;
        this.personId = personId;
        this.typesId = types;
        this.deposit = deposit;
        this.currency = currency;
        this.startDeposit = startDeposit;
        this.endDeposit = endDeposit;
        this.sum = sum;
        this.percent = percent;
    }

    public TypesOfDeposits getTypesId() {
        return typesId;
    }

    public void setTypesId(TypesOfDeposits typesId) {
        this.typesId = typesId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Deposits getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposits deposit) {
        this.deposit = deposit;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getStartDeposit() {
        return startDeposit;
    }

    public void setStartDeposit(Date startDeposit) {
        this.startDeposit = startDeposit;
    }

    public Date getEndDeposit() {
        return endDeposit;
    }

    public void setEndDeposit(Date endDeposit) {
        this.endDeposit = endDeposit;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }
}
