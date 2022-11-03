package com.manga.punpun.service;

import com.manga.punpun.interfaceService.IChapterService;
import com.manga.punpun.interfaceService.ICharacterService;
import com.manga.punpun.model.Chapter;
import com.manga.punpun.model.MangaCharacter;
import com.manga.punpun.repository.ChapterRepository;
import com.manga.punpun.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChapterService implements IChapterService {

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
