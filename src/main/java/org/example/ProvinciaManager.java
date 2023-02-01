package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ProvinciaManager {

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

        Provincia provincia = new Provincia();
        provincia.setId(1);
        provincia.setNombre("Málaga");
        provincia.setIdPais(2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(provincia);

        session.getTransaction().commit();
        session.close();
    }

    protected void read() {
        // code to get a book
        Session session = sessionFactory.openSession();

        int id = 1;
        Provincia provincia = session.get(Provincia.class,id);

        System.out.println("ID PROVINCIA: " +provincia.getId());
        System.out.println("NOMBRE PROVINCIA: "+provincia.getNombre());
        System.out.println("ID PAIS: "+provincia.getIdPais());
    }

    protected void update() {
        // code to modify a book
        Provincia provincia = new Provincia();
        provincia.setId(1);
        provincia.setNombre("Sevilla");
        provincia.setIdPais(7);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(provincia);

        session.getTransaction().commit();
        session.close();

    }

    protected void delete() {
        // code to remove a book
        Provincia provincia = new Provincia();
        provincia.setId(1);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(provincia);

        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        // code to run the program
        ProvinciaManager provinciaManager = new ProvinciaManager();
        provinciaManager.setUp();
        provinciaManager.delete();
        provinciaManager.exit();
    }
}
