package com.manga.punpun.rest;

import com.manga.punpun.interfaceService.ICharacterService;
import com.manga.punpun.model.MangaCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
public class CharacterRestController {

    @Autowired
    private ICharacterService service;

    @GetMapping("/page/{page}")
    public Page<MangaCharacter> listCharacters(@PathVariable Integer page){
        return service.listCharacter(PageRequest.of(page,15));
    }
}
