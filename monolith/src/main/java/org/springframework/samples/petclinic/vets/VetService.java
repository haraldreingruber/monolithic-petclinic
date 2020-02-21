package org.springframework.samples.petclinic.vets;

import org.springframework.samples.petclinic.model.NamedEntity;
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

    public Collection<VetDto> allVetsNew() {
        return this.vets.findAll()
            .stream()
            .map(this::mapToDto)
            .collect(Collectors.toList());
    }

    private VetDto mapToDto(Vet vet) {
        String[] specialties = vet.getSpecialties().stream()
            .map(NamedEntity::getName)
            .toArray(String[]::new);
        return new VetDto(vet.getFirstName(), vet.getLastName(), specialties);
    }
}