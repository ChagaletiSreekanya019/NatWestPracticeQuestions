package org.uplift.libraryproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uplift.libraryproject.model.Book;
import org.uplift.libraryproject.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibrarianControler {
    private Book book;
    @Autowired
    private LibraryService ls;
    @RequestMapping("/")
    public String index(){
        return "welcome to library";
    }
    @RequestMapping("/getbook/{id}")
    public ResponseEntity<Book>  getBookById(@PathVariable String id){
        Book b=ls.findById(id);
        if(b==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);

    }


}
