package com.manga.punpun.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "characters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaCharacter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character")
    private Integer idCharacter;

    @Column(length = 85)
    private String name;

    @Column(name = "image")
    private String nameImage;

    @Column(length = 6)
    private String gender;

    @Column(length = 15)
    private String status;

    @Column(length = 20)
    private String species;

    @ManyToMany(mappedBy = "characters")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","volume", "characters"})
    private List<Chapter> chapters;

    public String getImage() {return "http://localhost:9898/api/v0/character/photo/"+getIdCharacter();}
    public String getUrl(){
        return "http://localhost:9898/api/v0/character/"+getIdCharacter();
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
