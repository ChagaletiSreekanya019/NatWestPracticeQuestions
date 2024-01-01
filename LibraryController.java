package org.uplift.libraryproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uplift.libraryproject.model.Book;
import org.uplift.libraryproject.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private Book book;
    @Autowired
    private LibraryService ls;
    @RequestMapping("/book/{id}")
    public ResponseEntity<Book> borrowBook(@PathVariable String id,@PathVariable String phoneNum, @RequestParam String action){
        if(!action.equals("borrow")){
            return null;
        }
        System.out.println("Going to borrow");
        Book b=ls.borrow(id,phoneNum);
        if(b==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);

    }

}
