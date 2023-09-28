package com.telefonica.rickandmortyfinder.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.telefonica.rickandmortyfinder.model.CharacterResponse;

@Service
public class RickAndMortyApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    public CharacterResponse getCharacterByName(String name) {
        String rickAndMortyApiBaseUrl = "https://rickandmortyapi.com/api";
        String characterUrl = rickAndMortyApiBaseUrl + "/character/?name=" + name;
        return restTemplate.getForObject(characterUrl, CharacterResponse.class);
    }
}
