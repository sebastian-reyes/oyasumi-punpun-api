package com.manga.punpun.service;

import com.manga.punpun.interfaceService.ICharacterService;
import com.manga.punpun.model.MangaCharacter;
import com.manga.punpun.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private CharacterRepository repository;

    @Override
    public Page<MangaCharacter> listCharacter(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public MangaCharacter findCharacter(int id) {
        return repository.findById(id).orElse(null);
    }
}
