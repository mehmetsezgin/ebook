package com.mehmet.ebook.core.repository;

import com.mehmet.ebook.core.entity.Book;
import com.mehmet.ebook.core.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByBookName(String bookName);

    List<Book> getBooksByAuthorId(Long authorId);

    List<Book> getBooksByGenres(Genre genre);
}
