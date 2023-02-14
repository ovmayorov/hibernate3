package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name="authors")
@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    //owning side
    @ManyToOne
    @JoinColumn(name="country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy= "author")
    private List<Book> books;
}
