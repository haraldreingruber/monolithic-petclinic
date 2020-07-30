package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.vets.VetDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;

@Service
public class VetDtoClient {
    public Collection<VetDto> allVets() {
        RestTemplate restTemplate = new RestTemplate();
        String vetsResourceUrl = "http://localhost:8081/vets";
        return Arrays.asList(restTemplate.getForObject(vetsResourceUrl, VetDto[].class));
    }
}
