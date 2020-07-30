package org.springframework.samples.petclinic.vets;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class VetService {
    final VetRepository vets;

    public VetService(VetRepository vets) {
        this.vets = vets;
    }

    public Collection<Vet> allVets() {
        return this.vets.findAll();
    }

    public Collection<VetDto> allVetsDtos() {
        return this.vets.findAll().stream().map(vet -> new VetDto(
                vet.getFirstName(),
                vet.getLastName(),
                vet.getSpecialties()
        )).collect(Collectors.toList());
    }
}