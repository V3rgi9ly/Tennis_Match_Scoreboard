package repository;

import model.Match;
import model.Players;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class LocalRepository  {


    HibernateUtil configHibernate = HibernateUtil.getInstance();

    public List<Players> create(String val1, String val2) {

        List<Players> players1 = new ArrayList<>();

        try(Session session = configHibernate.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Players> query = session.createQuery("from Players where name in (:val1, :val2)");
            query.setParameter("val1", val1);
            query.setParameter("val2", val2);
            players1 = query.list();
            session.getTransaction().commit();
        }

        return players1;
    }




}
