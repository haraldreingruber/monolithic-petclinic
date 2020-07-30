package org.springframework.samples.petclinic.model;

import java.util.Objects;

public class SpecialtyDto {
    private String name;

    public String getName() {
        return name;
    }

    public SpecialtyDto(){}
    public SpecialtyDto(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialtyDto specialtyDto = (SpecialtyDto) o;
        return Objects.equals(name, specialtyDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
