package com.eksamensprojekt.eksamensprojektisaacohana.Models;


import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Table(name="Candidates")
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    //Candidate Firstname
    @Column
    private String firstname;

    //Candidate Lastname
    @Column
    private String lastname;

    //Commune
    @Column
    private String commune;

    @ManyToOne
    @JoinColumn(name = "party_id")
    @Nullable
    private Party party;

    public Candidate(String firstname, String lastname, String commune, Party party) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.commune = commune;
        this.party = party;
    }

    public Candidate() {

    }
}
