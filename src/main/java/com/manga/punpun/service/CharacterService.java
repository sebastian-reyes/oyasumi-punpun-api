package com.manga.punpun.service;

import com.manga.punpun.model.entity.MangaCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterService {
    public Page<MangaCharacter> listCharacter(Pageable pageable);
    public MangaCharacter findCharacter(int id);
}
