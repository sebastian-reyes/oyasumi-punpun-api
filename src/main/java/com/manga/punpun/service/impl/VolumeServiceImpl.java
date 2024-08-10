package com.manga.punpun.service.impl;

import com.manga.punpun.model.entity.Volume;
import com.manga.punpun.repository.VolumeRepository;
import com.manga.punpun.service.VolumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VolumeServiceImpl implements VolumeService {

    private final VolumeRepository repository;

    @Override
    public List<Volume> listVolumes() {
        return repository.findAll();
    }

    @Override
    public Volume findVolume(int id) {
        return repository.findById(id).orElse(null);
    }
}
