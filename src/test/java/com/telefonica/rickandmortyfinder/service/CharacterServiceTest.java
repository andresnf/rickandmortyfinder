package com.telefonica.rickandmortyfinder.service;

import com.telefonica.rickandmortyfinder.exception.CharacterNotFoundException;
import com.telefonica.rickandmortyfinder.model.CharacterResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.telefonica.rickandmortyfinder.model.Character;
import com.telefonica.rickandmortyfinder.model.CharacterAppearance;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CharacterServiceTest {

    @InjectMocks
    private CharacterService characterService;

    @Mock
    private RickAndMortyApiService apiService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetCharacterAppearanceByName_ExistingCharacter() {
        // Arrange
        // Mock the response from RickAndMortyApiService
        CharacterResponse characterResponse = new CharacterResponse();
        List<Character> characters = new ArrayList<>();
        Character character = new Character();
        character.setName("Rick Sanchez");
        character.setEpisodes(List.of("Pilot", "Lawnmower Dog"));
        character.setFirstAppearance("2017-11-10");
        characters.add(character);
        characterResponse.setResults(characters);

        when(apiService.getCharacterByName("Rick Sanchez")).thenReturn(characterResponse);

        // Act
        CharacterAppearance appearance = characterService.getCharacterAppearanceByName("Rick Sanchez");

        // Assert
        assertNotNull(appearance);
        assertEquals("Rick Sanchez", appearance.getName());
        assertEquals(List.of("Pilot", "Lawnmower Dog"), appearance.getEpisodes());
        assertEquals("2017-11-10", appearance.getFirstAppearance());
    }

    @Test
    public void testGetCharacterAppearanceByName_NonExistingCharacter() {
        // Arrange
        // Mock the response from RickAndMortyApiService
        when(apiService.getCharacterByName("NonExistentCharacter")).thenReturn(null);

        // Act and Assert
        // The service should throw CharacterNotFoundException
        try {
            characterService.getCharacterAppearanceByName("NonExistentCharacter");
            fail("Expected CharacterNotFoundException was not thrown");
        } catch (CharacterNotFoundException e) {
            // Exception was thrown as expected
        }
    }
}
