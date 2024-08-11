package com.manga.punpun.service;

import com.manga.punpun.model.dto.ChapterDto;
import com.manga.punpun.model.entity.Chapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ChapterService {
    Page<ChapterDto> listChapter(Pageable pageable);
    Optional<ChapterDto> findChapter(int id);
}
