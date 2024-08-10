package com.manga.punpun.service.impl;

import com.manga.punpun.model.dto.ChapterDto;
import com.manga.punpun.model.entity.Chapter;
import com.manga.punpun.model.entity.MangaCharacter;
import com.manga.punpun.repository.ChapterRepository;
import com.manga.punpun.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository repository;

    @Override
    public Page<ChapterDto> listChapter(Pageable pageable) {
        Page<Chapter> chapters = repository.findAll(pageable);
        return chapters.map(this::mapIntoDto);
    }

    @Override
    public ChapterDto findChapter(int id) {
        return repository.findById(id).map(this::mapIntoDto).orElse(null);
    }

    private ChapterDto mapIntoDto(Chapter chapter) {
        return ChapterDto.builder()
                .idChapter(chapter.getIdChapter())
                .name(chapter.getName())
                .volumeId(chapter.getVolume().getIdVolume())
                .mangaCharactersIds(chapter.getCharacters()
                        .stream()
                        .map(MangaCharacter::getIdCharacter)
                        .collect(Collectors.toList()))
                .build();
    }
}
