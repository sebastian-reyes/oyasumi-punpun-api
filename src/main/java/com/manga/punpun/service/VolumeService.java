package com.manga.punpun.service;

import com.manga.punpun.interfaceService.IVolumeService;
import com.manga.punpun.model.Volume;
import com.manga.punpun.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeService implements IVolumeService {

    @Autowired
    private VolumeRepository repository;

    @Override
    public List<Volume> listVolumes() {
        return repository.findAll();
    }

    @Override
    public Volume findVolume(int id) {
        return repository.findById(id).orElse(null);
    }
}
