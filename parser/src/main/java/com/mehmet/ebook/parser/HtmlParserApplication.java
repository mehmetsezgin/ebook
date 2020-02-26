package com.mehmet.ebook.parser;

import com.mehmet.ebook.core.entity.Author;
import com.mehmet.ebook.core.entity.Book;
import com.mehmet.ebook.core.entity.Genre;
import com.mehmet.ebook.core.service.AuthorService;
import com.mehmet.ebook.core.service.BookService;
import com.mehmet.ebook.core.service.GenreService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.io.File;
import java.util.*;

@SpringBootApplication(scanBasePackages = "com.mehmet.ebook.core")
@EntityScan(basePackages = "com.mehmet.ebook.core.entity")
@EnableJpaRepositories(basePackages = "com.mehmet.ebook.core.repository")
public class HtmlParserApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    public static void main(String[] args) {
        SpringApplication.run(HtmlParserApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        File input = new File("/home/mehmet/Downloads/KATALOG.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Book book;
        Elements rows = doc.getElementsByTag("tr");
        Map<String, Author> authors = new HashMap<>();
        Map<String, Genre> genres = new HashMap<>();

        for (Element row : rows.subList(1, rows.size() - 1)) {
            Elements cells = row.getElementsByTag("td");
            Author author;
            String authorName = cells.get(2).text().trim();
            if (!authors.containsKey(authorName)) {
                author = new Author(authorName);
                authors.put(authorName,author);
            }

            String[] genreArray = cells.get(5).text().split(",");
            for (String genre : genreArray) {
                if (!genres.containsKey(genre.trim())) {
                    Genre genreEntity = new Genre(genre.trim());
                    genres.put(genre.trim(),genreEntity);
                }
            }
        }


        for (Element row : rows.subList(1, rows.size() - 1)) {
            Elements cells = row.getElementsByTag("td");
            book = new Book();
            //book.setDescription(cells.get(1).text());

            book.setBookName(cells.get(3).text());
            book.setPublisher(cells.get(4).text());
            String[] genreArray = cells.get(5).text().split(",");
            for (String genre : genreArray) {
                book.addGenre(genres.get(genre.trim()));
            }
            //book.setMeritrokrasiRate(Integer.parseInt(cells.get(6).text()));

            String authorName = cells.get(2).text().trim();
            Author author = authors.get(authorName);
            book.setAuthor(author);
            author.addBook(book);
        }


        for (Map.Entry<String, Author> entry : authors.entrySet()) {
            authorService.addAuthor(entry.getValue());
        }


    }
}
