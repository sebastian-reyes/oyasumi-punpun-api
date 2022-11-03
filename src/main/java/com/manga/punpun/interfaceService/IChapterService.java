package com.manga.punpun.interfaceService;

import com.manga.punpun.model.Chapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IChapterService {
    public Page<Chapter> listChapter(Pageable pageable);
    public Chapter findChapter(int id);
}
