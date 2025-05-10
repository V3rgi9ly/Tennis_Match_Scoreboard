package repository;

import model.Players;
import org.hibernate.Session;
import org.hibernate.cache.spi.QueryResultsCache;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayersRepository  implements InterfacePlayersRepository<Players>{

    HibernateUtil configHibernate;

    public PlayersRepository() {
        configHibernate=HibernateUtil.getInstance();
    }


    public void create(String name1){
        Session session = configHibernate.configurationHibernate().getCurrentSession();
        try {
            session.beginTransaction();
            Players playerOne = new Players(name1);
            session.save(playerOne);
            session.getTransaction().commit();

        }finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }
    }

    @Override
    public void create(String name1, String name2) {
        Session session = configHibernate.configurationHibernate().getCurrentSession();

        try {
            session.beginTransaction();
            Players playerOne = new Players(name1);
            Players playerTwo = new Players(name2);
            session.save(playerOne);
            session.save(playerTwo);
            session.getTransaction().commit();
        }finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }
    }

    @Override
    public List<Players> findAll(String playerOne, String playerTwo) {
        Session session = configHibernate.configurationHibernate().getCurrentSession();
        List<Players> players=null;

        try {
            session.beginTransaction();
          players=session.createQuery("from Players where name in (:playerOne, :playerTwo)").list();
            session.getTransaction().commit();
        }
        finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }
        return players;
    }

    @Override
    public List<Players> find(String val) {
        Session session = configHibernate.configurationHibernate().getCurrentSession();
        List<Players> players=new ArrayList<>();

        try {
            session.beginTransaction();
            Query<Players> query=session.createQuery("from Players where name=:val", Players.class);
            query.setParameter("val", val);
            players=query.list();
            session.getTransaction().commit();
//            players=session.createQuery("from Players where name=:val").list();
        }
        finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }
        return players;
    }

    @Override
    public void update() {

    }
}
