package com.eksamensprojekt.eksamensprojektisaacohana.Controller;

import com.eksamensprojekt.eksamensprojektisaacohana.Models.Candidate;
import com.eksamensprojekt.eksamensprojektisaacohana.Models.Party;
import com.eksamensprojekt.eksamensprojektisaacohana.Repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyController {

    @Autowired
    PartyRepository parties;

    @GetMapping("/parties")
    public Iterable<Party> getParties() {
        return parties.findAll();
    }
}
