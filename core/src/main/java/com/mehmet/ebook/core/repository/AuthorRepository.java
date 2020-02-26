package com.mehmet.ebook.core.repository;

import com.mehmet.ebook.core.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getAuthorByAuthorName(String authorName);

}
