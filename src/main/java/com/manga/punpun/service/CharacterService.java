package com.manga.punpun.service;

import com.manga.punpun.model.dto.MangaCharacterDto;
import com.manga.punpun.model.entity.MangaCharacter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CharacterService {
    Page<MangaCharacterDto> listCharacter(Pageable pageable);
    Optional<MangaCharacterDto> findCharacter(int id);
}
