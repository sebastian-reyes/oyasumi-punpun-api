package com.manga.punpun.rest;

import com.manga.punpun.interfaceService.ICharacterService;
import com.manga.punpun.model.MangaCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/character")
public class CharacterRestController {

    @Autowired
    private ICharacterService service;

    @GetMapping("/page/{page}")
    public Page<MangaCharacter> getCharacters(@PathVariable Integer page) {
        return service.listCharacter(PageRequest.of(page, 15));
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
                response.put("message", "Volume not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("message", "Error when querying the database.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
