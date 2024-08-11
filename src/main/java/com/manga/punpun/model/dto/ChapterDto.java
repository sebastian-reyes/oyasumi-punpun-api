package com.manga.punpun.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties({"chapters", "description", "image"})
    private VolumeDto volume;
    @JsonIgnoreProperties({"chapters"})
    private List<MangaCharacterDto> characters;
    private String url;
}
