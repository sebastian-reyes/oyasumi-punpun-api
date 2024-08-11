package com.manga.punpun.service.impl;

import com.manga.punpun.model.dto.ChapterDto;
import com.manga.punpun.model.dto.MangaCharacterDto;
import com.manga.punpun.model.dto.VolumeDto;
import com.manga.punpun.model.entity.Chapter;
import com.manga.punpun.model.entity.MangaCharacter;
import com.manga.punpun.model.entity.Volume;
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
        return chapters.map(this::mapToChapterDto);
    }

    @Override
    public ChapterDto findChapter(int id) {
        return repository.findById(id).map(this::mapToChapterDto).orElse(null);
    }

    private ChapterDto mapToChapterDto(Chapter chapter) {
        return ChapterDto.builder()
                .idChapter(chapter.getIdChapter())
                .name(chapter.getName())
                .volume(mapToVolumeDto(chapter.getVolume()))
                .characters(chapter.getCharacters()
                        .stream()
                        .map(this::mapToMangaCharacterDto)
                        .collect(Collectors.toList()))
                .url(chapter.getUrl())
                .build();
    }

    private VolumeDto mapToVolumeDto(Volume volume) {
        return VolumeDto.builder()
                .idVolume(volume.getIdVolume())
                .name(volume.getName())
                .url(volume.getUrl())
                .build();
    }

    private MangaCharacterDto mapToMangaCharacterDto(MangaCharacter character) {
        return MangaCharacterDto.builder()
                .idCharacter(character.getIdCharacter())
                .name(character.getName())
                .nameImage(character.getNameImage())
                .gender(character.getGender())
                .status(character.getStatus())
                .species(character.getSpecies())
                .url(character.getUrl())
                .image(character.getImage())
                .build();
    }
}
