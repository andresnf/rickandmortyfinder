package com.telefonica.rickandmortyfinder.service;

import com.telefonica.rickandmortyfinder.model.CharacterResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class RickAndMortyApiServiceTest {

    @InjectMocks
    private RickAndMortyApiService apiService;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetCharacterByName_ExistingCharacter() {
        // Arrange
        String existingCharacterName = "Rick Sanchez";

        // Mock the behavior of RestTemplate to return a valid CharacterResponse
        CharacterResponse mockResponse = new CharacterResponse();
        // ... Initialize mockResponse with character data ...
        when(restTemplate.getForObject("https://rickandmortyapi.com/api/character/?name=" + existingCharacterName, CharacterResponse.class)).thenReturn(mockResponse);

        // Act
        CharacterResponse result = apiService.getCharacterByName(existingCharacterName);

        // Assert
        assertNotNull(result);
    }

    @Test(expected = HttpClientErrorException.NotFound.class)
    public void testGetCharacterByName_NonExistingCharacter() {
        // Arrange
        String nonExistingCharacterName = "NonExistentCharacter";

        // Mock the behavior of RestTemplate to throw HttpClientErrorException with 404 status code
        when(restTemplate.getForObject("https://rickandmortyapi.com/api/character/?name=" + nonExistingCharacterName, CharacterResponse.class))
                .thenThrow(HttpClientErrorException.NotFound.class);

        // Act
        apiService.getCharacterByName(nonExistingCharacterName);

        // Assert
        // Expects HttpClientErrorException.NotFound to be thrown
    }
}