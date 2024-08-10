package com.manga.punpun.repository;

import com.manga.punpun.model.entity.Volume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeRepository extends JpaRepository<Volume, Integer> {
}
