package com.manga.punpun.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_character;

    @Column(length = 85)
    private String name;

    private String image;

    @Column(length = 6)
    private String gender;

    @Column(length = 15)
    private String status;

    @Column(length = 20)
    private String species;

    @ManyToMany(mappedBy = "characters")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","volume", "characters"})
    private List<Chapter> chapters;
}
