package com.ijse.bookStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=false)
    private String title;

    @Column(unique=false)
    private String author;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String image;

    @Column(unique=false)
    private String description;
}
