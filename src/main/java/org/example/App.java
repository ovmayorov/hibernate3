package org.example;

import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Shop.class)
                .addAnnotatedClass(Theme.class)
                .addAnnotatedClass(Sale.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Author myAuthor = session.get(Author.class, 10);
            System.out.println("Author: " + myAuthor.getName());
            System.out.println("Country:" + myAuthor.getCountry().getName());
            //System.out.println("Books: ");
            myAuthor.getBooks().forEach(b -> System.out.println("Book: " + b.getName()));

            Book myBook = session.get(Book.class, 3);
            System.out.println("Book :" + myBook.getName());
            System.out.println("Author: " + myBook.getAuthor().getName());
            System.out.println("Country: " + myBook.getAuthor().getCountry().getName());
            System.out.println("Pages: " + myBook.getPages());
            System.out.println("Theme: " + myBook.getTheme().getName());
            System.out.println("Price: " + myBook.getPrice());


            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
        }finally {
            sessionFactory.close();
        }


    }
}
