package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    public static Session getSession() {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();
        SessionFactory sessionFactory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();
        return sessionFactory.openSession();
    }
}