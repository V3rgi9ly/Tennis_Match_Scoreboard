package repository;

import org.hibernate.Session;
import util.ConfigurationData;
import util.HibernateUtil;

public class PlayersDAO {

    HibernateUtil configHibernate = HibernateUtil.getInstance();
    ConfigurationData configurationData=ConfigurationData.getInstance();

    public void findPlayers(String nameOne, String nameTwo) {


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


    public void addCurrentMathes(){

    }

}
