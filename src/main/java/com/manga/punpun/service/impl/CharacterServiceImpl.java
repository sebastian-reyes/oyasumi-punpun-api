package com.manga.punpun.service.impl;

import com.manga.punpun.model.entity.MangaCharacter;
import com.manga.punpun.repository.CharacterRepository;
import com.manga.punpun.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;

    @Override
    public Page<MangaCharacter> listCharacter(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public MangaCharacter findCharacter(int id) {
        return repository.findById(id).orElse(null);
    }
}
