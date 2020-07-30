package org.springframework.samples.petclinic.model;

public class SpecialtyDto {
    private String name;

    public String getName() {
        return name;
    }

    public SpecialtyDto(){}
    public SpecialtyDto(String name) {
        this.name = name;
    }
}
