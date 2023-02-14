package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Table(name="countries")
@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="country")
    private List<Author> author;

    @OneToMany(mappedBy = "country")
    private List<Shop> shop;

}
