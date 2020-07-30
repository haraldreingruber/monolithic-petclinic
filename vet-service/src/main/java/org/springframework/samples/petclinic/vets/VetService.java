package org.springframework.samples.petclinic.vets;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetService {
    final VetRepository vets;

    public VetService(VetRepository vets) {
        this.vets = vets;
    }

    public Collection<Vet> allVetsEntities() {
        return this.vets.findAll();
    }

    public Collection<VetDto> allVets() {
        return this.vets.findAll().stream().map(vet -> new VetDto(
                vet.getFirstName(),
                vet.getLastName(),
                generateSpecialtiesDos(vet.getSpecialties())
        )).collect(Collectors.toList());
    }

    private List<SpecialtyDto> generateSpecialtiesDos(List<Specialty> specialties) {
        return specialties.stream().map(specialty -> new SpecialtyDto(specialty.getName())).collect(Collectors.toList());
    }
}