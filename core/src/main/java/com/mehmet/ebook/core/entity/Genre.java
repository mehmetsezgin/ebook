package com.mehmet.ebook.core.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    @ManyToMany(mappedBy = "genres")
    private List<Book> books = new ArrayList<>();

    public Genre() {
    }

    public Genre(String genreName) {
        this.genreName = genreName;
    }

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre = (Genre) o;
        return Objects.equals(getGenreName(), genre.getGenreName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGenreName());
    }
}
