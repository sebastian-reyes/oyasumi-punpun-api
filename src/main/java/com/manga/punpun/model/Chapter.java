package com.manga.punpun.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chapters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_chapter;

    @Column(name = "name", length = 15)
    private String name;

    @Column(unique = true)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_volume")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "chapters"})
    private Volume volume;

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
