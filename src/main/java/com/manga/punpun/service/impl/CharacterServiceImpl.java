package com.manga.punpun.service.impl;

import com.manga.punpun.model.dto.MangaCharacterDto;
import com.manga.punpun.model.entity.Chapter;
import com.manga.punpun.model.entity.MangaCharacter;
import com.manga.punpun.repository.CharacterRepository;
import com.manga.punpun.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository repository;

    @Override
    public Page<MangaCharacterDto> listCharacter(Pageable pageable) {
        Page<MangaCharacter> characters = repository.findAll(pageable);
        return characters.map(this::maptoMangaCharacterDto);
    }

    @Override
    public MangaCharacterDto findCharacter(int id) {
        return repository.findById(id).map(this::maptoMangaCharacterDto).orElse(null);
    }

    private MangaCharacterDto maptoMangaCharacterDto(MangaCharacter mangaCharacter) {
        return MangaCharacterDto.builder()
                .idCharacter(mangaCharacter.getIdCharacter())
                .name(mangaCharacter.getName())
                .nameImage(mangaCharacter.getNameImage())
                .gender(mangaCharacter.getGender())
                .status(mangaCharacter.getStatus())
                .species(mangaCharacter.getSpecies())
                .chaptersIds(mangaCharacter.getChapters()
                        .stream()
                        .map(Chapter::getIdChapter)
                        .collect(Collectors.toList()))
                .build();
    }
}
