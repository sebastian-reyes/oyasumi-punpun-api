package com.manga.punpun.service.impl;

import com.manga.punpun.model.entity.Chapter;
import com.manga.punpun.repository.ChapterRepository;
import com.manga.punpun.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository repository;

    @Override
    public Page<Chapter> listChapter(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Chapter findChapter(int id) {
        return repository.findById(id).orElse(null);
    }
}
