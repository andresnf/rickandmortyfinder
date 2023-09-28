package com.telefonica.rickandmortyfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telefonica.rickandmortyfinder.exception.CharacterNotFoundException;
import com.telefonica.rickandmortyfinder.model.CharacterAppearance;
import com.telefonica.rickandmortyfinder.model.Character;
import com.telefonica.rickandmortyfinder.model.CharacterResponse;

@Service
public class CharacterService {

    private final RickAndMortyApiService apiService;

    @Autowired
    public CharacterService(RickAndMortyApiService apiService) {
        this.apiService = apiService;
    }

    public CharacterAppearance getCharacterAppearanceByName(String name) {
        CharacterResponse characterResponse = apiService.getCharacterByName(name);

        if (characterResponse != null && !characterResponse.getResults().isEmpty()) {
            Character character = characterResponse.getResults().get(0);
            CharacterAppearance characterAppearance = new CharacterAppearance();
            characterAppearance.setName(character.getName());
            characterAppearance.setEpisodes(character.getEpisodes());
            characterAppearance.setFirstAppearance(character.getFirstAppearance());
            return characterAppearance;
        } else {
            throw new CharacterNotFoundException("Character not found");
        }
    }
}
