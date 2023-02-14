package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Table(name="shops")
@Entity
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "shop")
    private List<Sale> sale;
}
