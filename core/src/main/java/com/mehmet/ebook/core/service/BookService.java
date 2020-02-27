package com.mehmet.ebook.core.service;

import com.mehmet.ebook.core.entity.Book;
import com.mehmet.ebook.core.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void addBook(Book book){
        bookRepository.save(book);
    }

    public Book getBookById(Long bookId){
        return bookRepository.getOne(bookId);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    public List<Book> getBooksByAuthorId(Long authorId){
        return bookRepository.getBooksByAuthorId(authorId);
    }
}
