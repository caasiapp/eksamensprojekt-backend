package com.eksamensprojekt.eksamensprojektisaacohana.Controller;

import com.eksamensprojekt.eksamensprojektisaacohana.Models.Candidate;
import com.eksamensprojekt.eksamensprojektisaacohana.Models.Party;
import com.eksamensprojekt.eksamensprojektisaacohana.Repositories.CandidateRepository;
import com.eksamensprojekt.eksamensprojektisaacohana.Repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidatesController {

    @Autowired
    CandidateRepository candidates;

    @Autowired
    PartyRepository parties;

    @GetMapping("/candidates")
    public Iterable<Candidate> getCandidates() {
        return candidates.findAll();
    }

    @GetMapping("/candidate/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidates.findById(id).get();
    }

    @GetMapping("/candidates/{partyName}")
    public List<Candidate> getCandidateListedByPartyName(@PathVariable("partyName") String partyName) {
        return candidates.findCandidatesByParty(parties.findPartyByPartyName(partyName));
    }

    @PostMapping("/candidates/{partyId}")
    public Candidate newCandidate(@RequestBody Candidate newCandidate, @PathVariable Long partyId) {
        Party party = parties.findById(partyId).get();
        return candidates.save(new Candidate(newCandidate.getFirstname(), newCandidate.getLastname(), newCandidate.getCommune(), party));
    }

    @DeleteMapping("/candidates/{id}")
    public void deleteCandidateById(@PathVariable Long id) {
        candidates.deleteById(id);
    }

    @PutMapping("/candidates/{id}")
    public Candidate updateCandidateById(@PathVariable Long id, @RequestBody Candidate candidateToUpdateWith) {
        if (candidates.existsById(id)) {
            Candidate oldCandidate = candidates.findById(id).get();
            candidateToUpdateWith.setId(id);
            candidateToUpdateWith.setParty(oldCandidate.getParty());
            return candidates.save(candidateToUpdateWith);
        }
        return null;
        }

    @PatchMapping("/candidates/{id}")
    public String patchCandidateById(@PathVariable Long id, @RequestBody Candidate candidateToUpdateWith) {
        return candidates.findById(id).map(foundCandidate -> {
            if (candidateToUpdateWith.getFirstname() != null)
                foundCandidate.setFirstname(candidateToUpdateWith.getFirstname());
            if (candidateToUpdateWith.getLastname() != null)
                foundCandidate.setLastname(candidateToUpdateWith.getLastname());
            if (candidateToUpdateWith.getCommune() != null)
                foundCandidate.setCommune(candidateToUpdateWith.getCommune());
            candidates.save(foundCandidate);
            return "Success! Candidate was updated";
        }).orElse("Candidate was not updated..");
    }
}