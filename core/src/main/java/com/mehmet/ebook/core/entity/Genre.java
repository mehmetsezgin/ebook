package com.mehmet.ebook.core.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id")
    private Long id;

    @Column(name = "genre_name")
    private String genreName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}