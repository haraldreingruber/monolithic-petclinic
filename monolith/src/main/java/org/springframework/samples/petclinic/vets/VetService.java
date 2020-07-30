package org.springframework.samples.petclinic.vets;

import org.springframework.samples.petclinic.model.SpecialtyDto;
import org.springframework.samples.petclinic.model.VetDto;
import org.springframework.samples.petclinic.service.IVetService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VetService implements IVetService {
    final VetRepository vets;

    public VetService(VetRepository vets) {
        this.vets = vets;
    }

    public Collection<Vet> allVetsEntities() {
        return this.vets.findAll();
    }

    @Override
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