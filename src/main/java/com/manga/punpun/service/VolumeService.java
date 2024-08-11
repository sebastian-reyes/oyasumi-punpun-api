package com.manga.punpun.service;

import com.manga.punpun.model.dto.VolumeDto;
import com.manga.punpun.model.entity.Volume;

import java.util.List;
import java.util.Optional;

public interface VolumeService {
    List<VolumeDto> listVolumes();
    Optional<VolumeDto> findVolume(int id);
}
