package com.manga.punpun.interfaceService;

import com.manga.punpun.model.Volume;

import java.util.List;

public interface IVolumeService {
    public List<Volume> listVolumes();
    public Volume findVolume(int id);
}
