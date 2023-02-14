package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Table(name="books")
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="pages")
    private int pages;
    @Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private Author author;

    @ManyToOne
    @JoinColumn(name="theme_id", referencedColumnName = "id")
    private Theme theme;

    @OneToMany(mappedBy = "book")
    private List<Sale> sale;
}
