package com.example.BookJPA.controller;

import com.example.BookJPA.model.Book;
import com.example.BookJPA.model.BookResponce;
import com.example.BookJPA.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Log4j2
public class BookController {

@Autowired
   private BookService bookService;

    @PostMapping(path = "/books",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<BookResponce> createBook(@RequestBody Book book){

        BookResponce bookResponce= bookService.createBook(book);

        return new ResponseEntity<>(bookResponce, HttpStatus.OK);

    }


    @GetMapping(path = "/books/bookId",produces = MediaType.APPLICATION_JSON_VALUE)

    public  ResponseEntity<Book> getBook(@PathVariable Long bookId){
        Book book=bookService.getBook(bookId);

        if(Objects.isNull(book)){
            log.info("Book With bookId "+bookId  + "Found");
        }
        else {
            ResponseEntity.noContent().build();

        }
        return new ResponseEntity<>(book,HttpStatus.OK);
    }



}
