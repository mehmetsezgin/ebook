package com.mehmet.ebook.core.service;

import com.mehmet.ebook.core.entity.Genre;
import com.mehmet.ebook.core.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public void addGenre(Genre genre){
        genreRepository.save(genre);
    }

    public Genre getGenreById(Long genreId){
        return genreRepository.getOne(genreId);
    }

    public void deleteGenre(Long genreId){
        genreRepository.deleteById(genreId);
    }

    public Genre getGenreByGenreName(String genreName){
        return genreRepository.getGenreByGenreName(genreName);
    }

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
}
