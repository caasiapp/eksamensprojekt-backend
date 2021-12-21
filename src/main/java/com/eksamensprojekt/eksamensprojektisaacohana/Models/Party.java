package com.eksamensprojekt.eksamensprojektisaacohana.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name="parties")
@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String partyName;

    @Column
    private String votes;

    @JsonIgnore
    @OneToMany(mappedBy = "party", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Candidate> candidates;

}
