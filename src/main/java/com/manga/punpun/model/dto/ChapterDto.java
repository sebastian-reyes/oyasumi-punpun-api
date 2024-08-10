package com.manga.punpun.model.dto;

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
    private Integer idChapter;
    private String name;
    private Integer volumeId;
    private List<Integer> mangaCharactersIds;
    public String getUrl() {
        return "http://localhost:9898/api/v0/chapter/" + getIdChapter();
    }
}
