package com.manga.punpun.service.impl;

import com.manga.punpun.model.entity.Chapter;
import com.manga.punpun.repository.ChapterRepository;
import com.manga.punpun.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository repository;

    @Override
    public Page<Chapter> listChapter(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Chapter findChapter(int id) {
        return repository.findById(id).orElse(null);
    }
}
