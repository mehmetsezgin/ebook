package com.mehmet.ebook.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "meritrokasi_rate")
    private Integer meritrokrasiRate;

    @Column(name = "size")
    private Double size;

    @Column(name = "yandex_link")
    private String yandexLink;

    @Column(name = "description", length = 5000)
    private String description;

    @Column(name = "good_reads_link")
    private String goodReadsLink;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getMeritrokrasiRate() {
        return meritrokrasiRate;
    }

    public void setMeritrokrasiRate(Integer meritrokrasiRate) {
        this.meritrokrasiRate = meritrokrasiRate;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getYandexLink() {
        return yandexLink;
    }

    public void setYandexLink(String yandexLink) {
        this.yandexLink = yandexLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoodReadsLink() {
        return goodReadsLink;
    }

    public void setGoodReadsLink(String goodReadsLink) {
        this.goodReadsLink = goodReadsLink;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
        genre.getBooks().add(this);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
        genre.getBooks().remove(this);
    }
}
