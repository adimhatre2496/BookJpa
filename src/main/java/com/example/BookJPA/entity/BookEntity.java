package com.example.BookJPA.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Books")

public class BookEntity {

    @Id
    private  Long id;
    @Column(name = "book_Name")
    private String bookName;
    @Column(name = "Author_Name")
    private  String authorName;
}

