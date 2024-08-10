package com.manga.punpun.service.impl;

import com.manga.punpun.model.dto.VolumeDto;
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
        return VolumeDto.builder().build();
    }
}
