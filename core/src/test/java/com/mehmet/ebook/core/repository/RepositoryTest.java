package com.mehmet.ebook.core.repository;

import com.mehmet.ebook.core.entity.Author;
import com.mehmet.ebook.core.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindByAuthorName() {
        Author author = new Author("adam fawler");
        entityManager.persist(author);

        Author adam_fawler = authorRepository.getAuthorByAuthorName("adam fawler");

        assertEquals(author.getAuthorName(), adam_fawler.getAuthorName());
    }

    @Test
    @Transactional
    public void testGetAllBooks(){
        Author author = new Author("adam fawler");
        Book b1 = new Book();
        b1.setBookName("b1");
        b1.setAuthor(author);
        Book b2 = new Book();
        b2.setBookName("b2");
        b2.setAuthor(author);

        author.addBook(b1);
        author.addBook(b2);
        entityManager.persist(author);

        Author adam_fawler = authorRepository.getAuthorByAuthorName("adam fawler");

        assertEquals(adam_fawler.getBooks().size(),2);

        Book b1FromDb = bookRepository.findBookByBookName("b1");
        Book b2FromDb = bookRepository.findBookByBookName("b2");

        assertEquals(b1.getBookName(),b1FromDb.getBookName());
        assertEquals(b2.getAuthor().getAuthorName(),b2FromDb.getAuthor().getAuthorName());

        Book b3 = new Book();
        b3.setBookName("b3");
        b3.setAuthor(adam_fawler);
        adam_fawler.addBook(b3);
        bookRepository.save(b3);

        Book b3FromDb = bookRepository.findBookByBookName("b3");
        assertEquals(b3.getBookName(),b3FromDb.getBookName());
        assertEquals(b3.getAuthor().getAuthorName(),b3FromDb.getAuthor().getAuthorName());

        adam_fawler = authorRepository.getAuthorByAuthorName("adam fawler");

        assertEquals(3, adam_fawler.getBooks().size());
    }

    @Test
    @Transactional
    public void testDeleteBook(){
        Author author = new Author("adam fawler");
        Book b1 = new Book();
        b1.setBookName("b1");
        b1.setAuthor(author);
        Book b2 = new Book();
        b2.setBookName("b2");
        b2.setAuthor(author);

        author.addBook(b1);
        author.addBook(b2);
        entityManager.persist(author);

        Author adam_fawler = authorRepository.getAuthorByAuthorName("adam fawler");

        assertEquals(adam_fawler.getBooks().size(),2);

        adam_fawler.removeBook(b2);

        authorRepository.save(adam_fawler);

        Author newAdam_Fawler = authorRepository.getAuthorByAuthorName("adam fawler");

        assertEquals(newAdam_Fawler.getBooks().size(),1);

    }

    @Test
    //@Transactional
    public void testDeleteSingleBook(){
        Book b1 = new Book();
        b1.setBookName("b1");
        entityManager.persist(b1);

        assertEquals(1,bookRepository.findAll().size());

        bookRepository.delete(b1);

        assertEquals(0,bookRepository.findAll().size());

    }


}