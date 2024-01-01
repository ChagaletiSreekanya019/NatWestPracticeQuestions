package org.uplift.libraryproject.repositry;

import org.springframework.stereotype.Repository;
import org.uplift.libraryproject.model.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class LibraryRepositry {
    private Set<Book> setAllBooks=new HashSet<>();
    private Map<String,Integer> inventary=new HashMap<>();
    private Map<String,Book> uesrBookMap=new HashMap<>();
    public Book borrowBook(String id){
            return new Book(id,"title","author","genere", LocalDate.of(2011,23,2));

    }
}
