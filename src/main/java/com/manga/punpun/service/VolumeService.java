package com.manga.punpun.service;

import com.manga.punpun.model.entity.Volume;

import java.util.List;

public interface VolumeService {
    public List<Volume> listVolumes();
    public Volume findVolume(int id);
}
