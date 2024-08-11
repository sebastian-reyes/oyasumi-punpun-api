package com.manga.punpun.service.impl;

import com.manga.punpun.model.dto.ChapterDto;
import com.manga.punpun.model.dto.MangaCharacterDto;
import com.manga.punpun.model.dto.VolumeDto;
import com.manga.punpun.model.entity.Chapter;
import com.manga.punpun.model.entity.MangaCharacter;
import com.manga.punpun.model.entity.Volume;
import com.manga.punpun.repository.VolumeRepository;
import com.manga.punpun.service.VolumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VolumeServiceImpl implements VolumeService {

    private final VolumeRepository repository;

    @Override
    public List<VolumeDto> listVolumes() {
        List<Volume> volumes = repository.findAll();
        return volumes.stream().map(this::mapToVolumeDto).collect(Collectors.toList());
    }

    @Override
    public VolumeDto findVolume(int id) {
        return repository.findById(id).map(this::mapToVolumeDto).orElse(null);
    }

    private VolumeDto mapToVolumeDto(Volume volume) {
        return VolumeDto.builder()
                .idVolume(volume.getIdVolume())
                .name(volume.getName())
                .description(volume.getDescription())
                .nameImage(volume.getNameImage())
                .image(volume.getImage())
                .chapters(volume.getChapters().stream().map(this::mapToChapterDto).collect(Collectors.toList()))
                .url(volume.getUrl())
                .build();
    }


    private ChapterDto mapToChapterDto(Chapter chapter) {
        return ChapterDto.builder()
                .idChapter(chapter.getIdChapter())
                .name(chapter.getName())
                .url(chapter.getUrl())
                .build();
    }

}
