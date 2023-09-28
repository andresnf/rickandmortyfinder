package com.telefonica.rickandmortyfinder.controller;

import com.telefonica.rickandmortyfinder.exception.CharacterNotFoundException;
import com.telefonica.rickandmortyfinder.model.CharacterAppearance;
import com.telefonica.rickandmortyfinder.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/search-character-appearance")
    @Operation(summary = "Search character appearances", description = "Returns character appearances and their first appearance.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success. Returns character appearances and first appearance."),
            @ApiResponse(responseCode = "404", description = "Character not found."),
            @ApiResponse(responseCode = "500", description = "Internal server error.")
    })
    public ResponseEntity<CharacterAppearance> searchCharacterAppearance(
            @Parameter(description = "Name of the character to search for", required = true)
            @RequestParam String name) {
        try {
            CharacterAppearance characterAppearance = characterService.getCharacterAppearanceByName(name);
            return ResponseEntity.ok(characterAppearance);
        } catch (CharacterNotFoundException e) {
            // Handle CharacterNotFoundException and return an HTTP 404 response
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            // Handle any other exception and return an HTTP 500 (Internal Server Error) response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
