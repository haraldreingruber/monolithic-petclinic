package org.springframework.samples.petclinic.vets;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.SpecialtyDto;
import org.springframework.samples.petclinic.model.VetDto;
import org.springframework.samples.petclinic.service.VetDtoClient;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

public class VetsClientTest {

    @Test
    void should_retrieve_vets_from_json_api() {
        WireMockServer wireMockServer = new WireMockServer(options().port(8081));
        wireMockServer.start();
        wireMockServer.stubFor(WireMock.get(urlEqualTo("/vets"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[\n" +
                                "  {\n" +
                                "    \"firstName\": \"James\",\n" +
                                "    \"lastName\": \"Carter\",\n" +
                                "    \"specialties\": [],\n" +
                                "    \"nrOfSpecialties\": 0\n" +
                                "  },\n" +
                                "  {\n" +
                                "    \"firstName\": \"Helen\",\n" +
                                "    \"lastName\": \"Leary\",\n" +
                                "    \"specialties\": [\n" +
                                "      \"radiology\"\n" +
                                "    ],\n" +
                                "    \"nrOfSpecialties\": 1\n" +
                                "  }" +
                                "]")));

        VetDtoClient vetsClient = new VetDtoClient();
        Collection<VetDto> vets = vetsClient.allVets();

        assertThat(vets).hasSize(2)
                .containsExactly(
                        new VetDto("James", "Carter", Collections.emptyList()),
                        new VetDto("Helen", "Leary", Arrays.asList(new SpecialtyDto("radiology")))
                );
        wireMockServer.stop();
    }
}
