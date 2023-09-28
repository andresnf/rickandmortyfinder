package com.telefonica.rickandmortyfinder.controller;

import com.telefonica.rickandmortyfinder.exception.CharacterNotFoundException;
import com.telefonica.rickandmortyfinder.model.CharacterAppearance;
import com.telefonica.rickandmortyfinder.service.CharacterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CharacterControllerTest {

    @InjectMocks
    private CharacterController characterController;

    @Mock
    private CharacterService characterService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testSearchCharacterAppearance_ExistingCharacter() {
        // Arrange
        String existingCharacterName = "Rick Sanchez";
        CharacterAppearance characterAppearance = new CharacterAppearance(existingCharacterName, null, null);
        when(characterService.getCharacterAppearanceByName(existingCharacterName)).thenReturn(characterAppearance);

        // Act
        ResponseEntity<?> responseEntity = characterController.searchCharacterAppearance(existingCharacterName);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(characterAppearance, responseEntity.getBody());
    }

    @Test
    public void testSearchCharacterAppearance_NonExistingCharacter() {
        // Arrange
        String nonExistingCharacterName = "NonExistentCharacter";
        when(characterService.getCharacterAppearanceByName(nonExistingCharacterName)).thenThrow(CharacterNotFoundException.class);

        // Act
        ResponseEntity<?> responseEntity = characterController.searchCharacterAppearance(nonExistingCharacterName);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testSearchCharacterAppearance_InternalServerError() {
        // Arrange
        String characterName = "SomeCharacter";
        when(characterService.getCharacterAppearanceByName(characterName)).thenThrow(RuntimeException.class);

        // Act
        ResponseEntity<?> responseEntity = characterController.searchCharacterAppearance(characterName);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}

