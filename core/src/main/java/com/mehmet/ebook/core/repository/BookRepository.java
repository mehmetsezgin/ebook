package com.mehmet.ebook.core.repository;

import com.mehmet.ebook.core.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByBookName(String bookName);
}
