package com.manga.punpun.service;

import com.manga.punpun.model.dto.VolumeDto;
import com.manga.punpun.model.entity.Volume;

import java.util.List;

public interface VolumeService {
    List<VolumeDto> listVolumes();
    VolumeDto findVolume(int id);
}
