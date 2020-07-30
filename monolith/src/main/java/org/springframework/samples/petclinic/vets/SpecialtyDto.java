package org.springframework.samples.petclinic.vets;

public class SpecialtyDto {
    private String name;

    public String getName() {
        return name;
    }

    public SpecialtyDto(String name) {
        this.name = name;
    }
}
