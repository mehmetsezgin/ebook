package com.mehmet.ebook.core.repository;

import com.mehmet.ebook.core.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre getGenreByGenreName(String genreName);
}
