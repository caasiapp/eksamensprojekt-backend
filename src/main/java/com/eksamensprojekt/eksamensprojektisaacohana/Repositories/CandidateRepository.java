package com.eksamensprojekt.eksamensprojektisaacohana.Repositories;

import com.eksamensprojekt.eksamensprojektisaacohana.Models.Candidate;
import com.eksamensprojekt.eksamensprojektisaacohana.Models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findCandidatesByParty(Party party);

}
