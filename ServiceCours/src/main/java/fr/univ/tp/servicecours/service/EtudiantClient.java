package fr.univ.tp.servicecours.service;

import fr.univ.tp.servicecours.dto.EtudiantDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EtudiantClient {

    private final RestTemplate rest;
    private final String baseUrl;

    public EtudiantClient(@Value("${etudiants.url:http://localhost:8081/etudiants}") String baseUrl) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(2000);
        factory.setReadTimeout(2000);
        this.rest = new RestTemplate(factory);
        this.baseUrl = baseUrl;
    }

    public EtudiantDto getEtudiantById(int id) {
        return rest.getForObject(baseUrl + "/" + id, EtudiantDto.class);
    }
}