package com.manga.punpun.service.impl;

import com.manga.punpun.model.entity.MangaCharacter;
import com.manga.punpun.repository.CharacterRepository;
import com.manga.punpun.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService {

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
