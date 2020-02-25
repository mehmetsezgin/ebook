package com.mehmet.ebook.core.service;

import com.mehmet.ebook.core.entity.Author;
import com.mehmet.ebook.core.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

}
