package com.manga.punpun.rest;

import com.manga.punpun.service.CharacterService;
import com.manga.punpun.model.entity.MangaCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/character")
public class CharacterRestController {

    @Autowired
    private CharacterService service;

    @GetMapping("/page/{page}")
    public Page<MangaCharacter> getCharacters(@PathVariable Integer page) {
        return service.listCharacter(PageRequest.of(page, 8));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCharacter(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        MangaCharacter character = null;
        try {
            character = service.findCharacter(id);
            if (character != null) {
                return new ResponseEntity<>(character, HttpStatus.OK);
            } else {
                response.put("message", "Character not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("message", "Error when querying the database.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<?> getCharacterPhoto(@PathVariable Integer id) throws IOException {
        MangaCharacter character = null;
        String name_photo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            character = service.findCharacter(id);
            if (character != null) {
                name_photo = character.getName_image();
                if (name_photo != null) {
                    File img = new File("src/main/resources/static/photos/" + name_photo);
                    return ResponseEntity.ok()
                            .contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img)))
                            .body(Files.readAllBytes(img.toPath()));
                } else {
                    response.put("message", "The character does not have a photo.");
                    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
                }
            } else {
                response.put("message", "Character not found.");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("message", "Error when querying the database.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
