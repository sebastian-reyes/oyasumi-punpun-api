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
public class VolumeDto {
    private Integer idVolume;
    private String name;
    private String description;
    private String image;
    List<Integer> chaptersIds;
}
