package org.springframework.samples.petclinic.vets;

import java.util.List;

public class VetDto {
    private String firstName;
    private String lastName;
    private List<Specialty> specialties;

    public VetDto(String firstName, String lastName, List<Specialty> specialties) {
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

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public int getNrOfSpecialties() {
        return getSpecialties().size();
    }

}
