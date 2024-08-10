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

    private String image;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "volume", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","volume","characters"})
    private List<Chapter> chapters;

    public String getUrl(){
        return "http://localhost:9898/api/v0/volume/"+getIdVolume();
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
