package repository;

import model.Players;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class PlayersDAO {

    HibernateUtil configHibernate = HibernateUtil.getInstance();

    public void findPlayers(Players nameOne, Players nameTwo) {


        Session session = configHibernate.configurationHibernate().openSession();

        try {
            session.beginTransaction();

//            List<Players> players=session.createQuery("from PLAYERS WHERE ")

            session.getTransaction().commit();
        } finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }

    }

}
