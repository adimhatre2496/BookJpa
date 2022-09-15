package com.example.BookJPA.service;

import com.example.BookJPA.entity.BookEntity;
import com.example.BookJPA.model.Book;
import com.example.BookJPA.model.BookResponce;
import com.example.BookJPA.repository.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookResponce createBook(Book book)
    {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(book.getBookName());
        bookEntity.setAuthorName(book.getAuthorName());

        Long id = (long) (Math.random() * 20);
        bookEntity.setId(id);

        BookResponce bookResponce = new BookResponce();
        bookResponce.setId(bookEntity.getId());

        bookRepository.save(bookEntity);

        log.info("Created Entry Record Of ID " + bookResponce);

        return bookResponce;

    }

    public Book getBook(Long bookId){

        Book book= new Book();


        Optional<BookEntity>bookEntity1=bookRepository.findById(bookId);

        if(bookEntity1.isPresent()){

            book.setBookName(bookEntity1.get().getBookName());
            book.setAuthorName(bookEntity1.get().getAuthorName());
        }

        else {
            log.info("book Id "+ bookId +"not found");
        }

        return book;





    }


}

