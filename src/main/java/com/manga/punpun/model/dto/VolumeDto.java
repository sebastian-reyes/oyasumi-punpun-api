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
public class VolumeDto {
    private Integer idVolume;
    private String name;
    private String description;
    private String nameImage;
    private String url;
    private String image;
    @JsonIgnoreProperties({"chapters", "characters", "volume"})
    List<ChapterDto> chapters;
}
