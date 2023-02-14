package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Table(name="themes")
@Entity
@Data
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "theme")
    private List<Book> book;

}
