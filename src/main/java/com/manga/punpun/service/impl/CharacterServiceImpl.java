package com.manga.punpun.service.impl;

import com.manga.punpun.model.dto.ChapterDto;
import com.manga.punpun.model.dto.MangaCharacterDto;
import com.manga.punpun.model.entity.Chapter;
import com.manga.punpun.model.entity.MangaCharacter;
import com.manga.punpun.repository.CharacterRepository;
import com.manga.punpun.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    public Optional<MangaCharacterDto> findCharacter(int id) {
        return repository.findById(id).map(this::maptoMangaCharacterDto);
    }

    private MangaCharacterDto maptoMangaCharacterDto(MangaCharacter mangaCharacter) {
        return MangaCharacterDto.builder()
                .idCharacter(mangaCharacter.getIdCharacter())
                .name(mangaCharacter.getName())
                .nameImage(mangaCharacter.getNameImage())
                .gender(mangaCharacter.getGender())
                .status(mangaCharacter.getStatus())
                .species(mangaCharacter.getSpecies())
                .chapters(mangaCharacter.getChapters()
                        .stream()
                        .map(this::maptoChapterDto)
                        .collect(Collectors.toList()))
                .url(mangaCharacter.getUrl())
                .image(mangaCharacter.getImage())
                .build();
    }

    private ChapterDto maptoChapterDto(Chapter chapter) {
        return ChapterDto.builder()
                .idChapter(chapter.getIdChapter())
                .name(chapter.getName())
                .url(chapter.getUrl())
                .build();
    }
}
