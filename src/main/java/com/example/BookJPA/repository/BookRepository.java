package com.example.BookJPA.repository;

import com.example.BookJPA.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <BookEntity ,Long>{
}
