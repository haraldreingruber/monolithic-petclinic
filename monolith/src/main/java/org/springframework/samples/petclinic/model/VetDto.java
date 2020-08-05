package org.springframework.samples.petclinic.model;

import java.util.List;
import java.util.Objects;

public class VetDto {
    private String firstName;
    private String lastName;
    private List<SpecialtyDto> specialties;

    public VetDto(){}

    public VetDto(String firstName, String lastName, List<SpecialtyDto> specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialties = specialties;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<SpecialtyDto> getSpecialties() {
        return specialties;
    }

    public int getNrOfSpecialties() {
        return getSpecialties().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VetDto vetDto = (VetDto) o;
        return Objects.equals(firstName, vetDto.firstName) &&
                Objects.equals(lastName, vetDto.lastName) &&
                Objects.equals(specialties, vetDto.specialties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, specialties);
    }

}
