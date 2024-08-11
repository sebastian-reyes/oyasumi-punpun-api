package com.manga.punpun.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "volumes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Volume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_volume")
    private Integer idVolume;

    @Column(length = 15)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "name_image")
    private String nameImage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "volume", cascade = CascadeType.ALL)
    private List<Chapter> chapters;

    public String getUrl(){
        return "http://localhost:9898/api/v0/volume/"+getIdVolume();
    }
    public String getImage() { return "http://localhost:9898/api/v0/volume/photo/"+getIdVolume(); }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
