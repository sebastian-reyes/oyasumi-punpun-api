package com.manga.punpun.model.dto;

import com.manga.punpun.model.entity.Volume;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChapterDto {
    private Integer id_chapter;
    private String name;
    private Volume volume;
    private List<MangaCharacterDto> mangaCharacters;
    public String getUrl() {
        return "http://localhost:9898/api/v0/chapter/" + getId_chapter();
    }
}
