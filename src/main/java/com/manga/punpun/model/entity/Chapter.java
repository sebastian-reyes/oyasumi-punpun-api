package com.manga.punpun.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "chapters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chapter")
    private Integer idChapter;

    @Column(name = "name", length = 15)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_volume")
    private Volume volume;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "chapters_characters", joinColumns = @JoinColumn(name = "id_chapter"),
            inverseJoinColumns = @JoinColumn(name = "id_character"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id_chapter", "id_character"})})
    private List<MangaCharacter> characters;

    public String getUrl(){
        return "http://localhost:9898/api/v0/chapter/"+getIdChapter();
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
