package repository;

import model.Players;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayersRepository {

    HibernateUtil configHibernate;

    public PlayersRepository() {
        configHibernate=HibernateUtil.getInstance();
    }


    public void create(String name1){

        try(Session session = configHibernate.getSessionFactory().openSession()) {
            session.beginTransaction();
            Players playerOne = new Players(name1);
            session.save(playerOne);
            session.getTransaction().commit();

        }
    }

    public void create(String name1, String name2) {


        try (Session session = configHibernate.getSessionFactory().openSession()){
            session.beginTransaction();
            Players playerOne = new Players(name1);
            Players playerTwo = new Players(name2);
            session.save(playerOne);
            session.save(playerTwo);
            session.getTransaction().commit();
        }
    }


    public List<Players> findAll(String playerOne, String playerTwo) {

        List<Players> players=null;

        try (Session session = configHibernate.getSessionFactory().openSession()){
            session.beginTransaction();
          players=session.createQuery("from Players where name in (:playerOne, :playerTwo)").list();
            session.getTransaction().commit();
        }
        return players;
    }


    public List<Players> find(String val) {

        List<Players> players=new ArrayList<>();

        try(Session session = configHibernate.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query<Players> query=session.createQuery("from Players where name=:val", Players.class);
            query.setParameter("val", val);
            players=query.list();
            session.getTransaction().commit();
        }

        return players;
    }


}
