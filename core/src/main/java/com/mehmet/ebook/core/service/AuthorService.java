package com.mehmet.ebook.core.service;

import com.mehmet.ebook.core.entity.Author;
import com.mehmet.ebook.core.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void addAuthor(Author author) throws Exception{
       authorRepository.save(author);
    }

    public Author getAuthorByAuthorName(String authorName){
        return authorRepository.getAuthorByAuthorName(authorName);
    }

}
