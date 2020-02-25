package com.mehmet.ebook.core.repository;

import com.mehmet.ebook.core.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
