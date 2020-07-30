package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.model.VetDto;

import java.util.Collection;

public interface IVetService {
    Collection<VetDto> allVets();
}
