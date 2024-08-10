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
public class MangaCharacterDto {
    private Integer idCharacter;
    private String name;
    private String nameImage;
    private String gender;
    private String status;
    private String species;
    private List<Integer> chaptersIds;
}
