package com.manga.punpun.rest;

import com.manga.punpun.interfaceService.IChapterService;
import com.manga.punpun.model.Chapter;
import com.manga.punpun.model.MangaCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private IChapterService service;

    @GetMapping("/page/{page}")
    public Page<Chapter> getChapters(@PathVariable Integer page) {
        return service.listChapter(PageRequest.of(page,15));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getChapter(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        Chapter chapter = null;
        try{
            chapter = service.findChapter(id);
            if(chapter!=null){
                return new ResponseEntity<>(chapter, HttpStatus.OK);
            }else {
                response.put("message", "Chapter not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException e) {
            response.put("message", "Error when querying the database.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
