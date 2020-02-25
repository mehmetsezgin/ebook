package com.mehmet.ebook.core;


import com.mehmet.ebook.core.entity.Author;
import com.mehmet.ebook.core.entity.Book;
import com.mehmet.ebook.core.entity.Genre;
import com.mehmet.ebook.core.service.AuthorService;
import com.mehmet.ebook.core.service.BookService;
import com.mehmet.ebook.core.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Genre adventure = new Genre();
        adventure.setGenreName("adventure");

        Genre action = new Genre();
        action.setGenreName("action");

        Book buick_8 = new Book();

        Author king = new Author();
        king.setAuthorName("Stephen King");
        Set<Book> kingBooks = new HashSet<>();
        kingBooks.add(buick_8);


        buick_8.setBookName("Buick 8");
        buick_8.setAuthor(king);

        genreService.addGenre(adventure);
        genreService.addGenre(action);

        authorService.addAuthor(king);

    }
}
