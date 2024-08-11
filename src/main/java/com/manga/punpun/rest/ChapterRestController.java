package com.manga.punpun.rest;

import com.manga.punpun.model.dto.ApiResponse;
import com.manga.punpun.model.dto.ChapterDto;
import com.manga.punpun.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter")
@RequiredArgsConstructor
public class ChapterRestController {

    private final ChapterService service;

    @GetMapping("/page/{page}")
    public Page<ChapterDto> getChapters(@PathVariable Integer page) {
        return service.listChapter(PageRequest.of(page, 15));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ChapterDto>> getChapter(@PathVariable Integer id) {
        return service.findChapter(id)
                .map(chapter -> new ResponseEntity<>(new ApiResponse<>(chapter, null, HttpStatus.OK), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new ApiResponse<>(null, "Chapter not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND));
    }
}
