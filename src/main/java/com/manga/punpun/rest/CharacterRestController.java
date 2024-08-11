package com.manga.punpun.rest;

import com.manga.punpun.model.dto.ApiResponse;
import com.manga.punpun.model.dto.MangaCharacterDto;
import com.manga.punpun.service.CharacterService;
import com.manga.punpun.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterRestController {

    private final CharacterService characterService;
    private final ImageService imageService;

    @GetMapping("/page/{page}")
    public Page<MangaCharacterDto> getCharacters(@PathVariable Integer page) {
        return characterService.listCharacter(PageRequest.of(page, 8));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MangaCharacterDto>> getCharacter(@PathVariable Integer id) {
        return characterService.findCharacter(id)
                .map(character -> new ResponseEntity<>(new ApiResponse<>(character, null, HttpStatus.OK), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new ApiResponse<>(null, "Character not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND));
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<?> getCharacterPhoto(@PathVariable Integer id) throws IOException {
        return characterService.findCharacter(id)
                .map(character -> {
                    String namePhoto = character.getNameImage();
                    if (namePhoto == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The character does not have a photo.");
                    }
                    return imageService.getImage("src/main/resources/static/photos/" + namePhoto);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found."));
    }
}
