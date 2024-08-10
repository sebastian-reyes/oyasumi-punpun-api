package com.manga.punpun.service.impl;

import com.manga.punpun.model.entity.Volume;
import com.manga.punpun.repository.VolumeRepository;
import com.manga.punpun.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeServiceImpl implements VolumeService {

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
