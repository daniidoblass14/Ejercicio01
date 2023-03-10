package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PaisManager {

    protected SessionFactory sessionFactory;

    protected void setUp(){

        final StandardServiceRegistry registry = new
                StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected void exit(){
        sessionFactory.close();
    }
    protected void create() {
        // code to save a book

        Pais pais = new Pais();
        pais.setId(1);
        pais.setNombre("Hungría");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(pais);

        session.getTransaction().commit();
        session.close();
    }

    protected void read() {
        // code to get a book
        Session session = sessionFactory.openSession();

        int idPais = 1;
        Pais pais = session.get(Pais.class,idPais);

        System.out.println("ID PAIS: " +pais.getId());
        System.out.println("NOMBRE PAIS: "+pais.getNombre());
    }

    protected void update() {
        // code to modify a book
        Pais pais = new Pais();
        pais.setId(1);
        pais.setNombre("España");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(pais);

        session.getTransaction().commit();
        session.close();

    }

    protected void delete() {
        // code to remove a book
        Pais pais = new Pais();
        pais.setId(1);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(pais);

        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        // code to run the program
        PaisManager paisManager = new PaisManager();
        paisManager.setUp();
        paisManager.create();
        paisManager.exit();
    }

}
