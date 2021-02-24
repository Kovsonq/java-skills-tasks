package course.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
public class MainClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Catalog.class)
                .buildSessionFactory();

        Session session = null;

        try {
            //Create
//            session = factory.getCurrentSession();
//            Catalog catalog = new Catalog("Drama 23");
//            session.beginTransaction();
//            session.save(catalog);
//            session.getTransaction().commit();

            //READ
            session = factory.getCurrentSession();
            session.beginTransaction();
            Catalog catalog1 = session.get(Catalog.class,1L); // cashing object
            Catalog catalog2 = session.get(Catalog.class,1L); // eager loading
            Catalog catalog3 = session.load(Catalog.class,2L); // lazy loading - proxy
            log.info("Result: {}", catalog3); // for getting this object
            session.getTransaction().commit();
            log.info("Result: {}", catalog1);
            log.info("Result: {}", catalog2);
            log.info("Result: {}", catalog3);

            // get object from one session and update in another
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            catalog1.setTitle("OldText");
//            session.update(catalog1);
//            session.getTransaction().commit();


            //Delete
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog2 = session.get(Catalog.class,1L);
//            session.remove(catalog1); // = session.delete(catalog1);
//            session.getTransaction().commit();
//            log.info("Was deleted: {}", catalog2);


        } finally {
            session.close();
            factory.close();
        }
    }
}
