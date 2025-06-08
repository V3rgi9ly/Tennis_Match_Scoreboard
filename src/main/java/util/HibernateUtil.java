package util;

import model.Matches;
import model.Players;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static HibernateUtil instance=new HibernateUtil();
    private final SessionFactory sessionFactory;
    private HibernateUtil() {
            this.sessionFactory=configurationHibernate();
    }

    public static HibernateUtil getInstance() {
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private SessionFactory configurationHibernate() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Players.class).addAnnotatedClass(Matches.class).getMetadataBuilder().build();
            return  metadata.getSessionFactoryBuilder().build();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
