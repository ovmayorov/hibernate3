package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Table(name="sales")
@Entity
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="quantity")
    private int quantity;
    @Column(name="sale_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name="shop_id", referencedColumnName = "id")
    private Shop shop;
}
