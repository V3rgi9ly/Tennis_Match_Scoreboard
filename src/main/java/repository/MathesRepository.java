package repository;

import model.Match;
import model.Matches;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class MathesRepository {
    HibernateUtil configHibernate = HibernateUtil.getInstance();

    public void save(Match values) {

        try (Session session = configHibernate.getSessionFactory().openSession()){
            session.beginTransaction();
            Matches matches = new Matches();
            matches.setPlayer1(values.getPlayersOne());
            matches.setPlayer2(values.getPlayer2());
            matches.setWinner(values.getWinner());

            session.save(matches);
            session.getTransaction().commit();

        }
    }

    public List<Matches> findAll(String val1) {

        List<Matches> matches = new ArrayList<>();
        try (Session session = configHibernate.getSessionFactory().openSession()){

            session.beginTransaction();
            Query<Matches> query = session.createQuery("from Matches where player1.name=:val or player2.name=:val");
            query.setParameter("val", val1);
            matches = query.list();
            session.getTransaction().commit();

        }
        return matches;
    }





    public List<Matches> findAll(int val1, int val2) {


        List<Matches> matches = new ArrayList<>();
        try (Session session = configHibernate.getSessionFactory().openSession()){

            session.beginTransaction();
            Query<Matches> query = session.createQuery("from Matches ");
            query.setFirstResult(val1);
            query.setMaxResults(val2);

            matches = query.list();
            session.getTransaction().commit();

        }
        return matches;
    }

    public List<Matches> findAll(String name, int val1, int val2) {


        List<Matches> matches = new ArrayList<>();
        try (Session session = configHibernate.getSessionFactory().openSession()){

            session.beginTransaction();
            Query<Matches> query = session.createQuery("from Matches where player1.name=:name or player2.name=:name").setParameter("name", name);
            query.setFirstResult(val1);
            query.setMaxResults(val2);

            matches = query.list();
            session.getTransaction().commit();

        }
        return matches;
    }


    public Long getCountInTable() {

        Long query;

        try (Session session = configHibernate.getSessionFactory().openSession()){
            session.beginTransaction();
            query = (Long)session.createQuery("select count(*) from Matches").getSingleResult();


            session.getTransaction().commit();
        }
        return query;
    }

    public Long getCountInTable(String val1) {

        Long query;

        try (Session session = configHibernate.getSessionFactory().openSession()){
            session.beginTransaction();
            query = (Long)session.createQuery("select count(*) from Matches where player1.name=:val1 or player2.name=:val1").setParameter("val1", val1).getSingleResult();


            session.getTransaction().commit();
        }
        return query;
    }
}
