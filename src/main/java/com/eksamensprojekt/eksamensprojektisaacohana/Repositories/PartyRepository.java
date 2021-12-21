package com.eksamensprojekt.eksamensprojektisaacohana.Repositories;

import com.eksamensprojekt.eksamensprojektisaacohana.Models.Candidate;
import com.eksamensprojekt.eksamensprojektisaacohana.Models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {

    Party findPartyByPartyName(String party);


}
