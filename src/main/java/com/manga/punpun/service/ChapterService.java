package com.manga.punpun.service;

import com.manga.punpun.model.entity.Chapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChapterService {
    public Page<Chapter> listChapter(Pageable pageable);
    public Chapter findChapter(int id);
}
