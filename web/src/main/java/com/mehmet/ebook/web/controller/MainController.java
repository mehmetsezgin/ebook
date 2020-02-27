package com.mehmet.ebook.web.controller;

import com.mehmet.ebook.core.entity.Book;
import com.mehmet.ebook.core.service.AuthorService;
import com.mehmet.ebook.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;


    /*@GetMapping({"/", "/person"})
    public String personForm(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }

    @GetMapping({"/view/{id}"})
    public String updateForm(@PathVariable String id, Model model) {
        Person personFromDb = personService.findById(Long.parseLong(id));
        model.addAttribute("person", personFromDb);
        return "view";
    }

    @GetMapping({"/delete/{id}"})
    public String delete(@PathVariable String id, Model model) {
        personService.deleteById(Long.parseLong(id));
        model.addAttribute("id", id);
        return "deleteresult";
    }

    @PostMapping("/person")
    public String personSubmit(@ModelAttribute Person person) {
        String fileName = StringUtils.cleanPath(person.getMultipartFile().getOriginalFilename());
        person.setFileName(fileName);
        try {
            person.setFile(person.getMultipartFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        personService.addPerson(person);
        return "result";
    }

     */


    @GetMapping({"/", "/authors"})
    public String listAuthors(Model model){
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping({"/books/{authorId}"})
    public String listBooks(@PathVariable String authorId, Model model){
        List<Book> books = bookService.getBooksByAuthorId(Long.parseLong(authorId));
        if(books.size() > 0){
            model.addAttribute("authorname",books.get(0).getAuthor().getAuthorName());
        }
        model.addAttribute("books",books);
        return "books";
    }
}
