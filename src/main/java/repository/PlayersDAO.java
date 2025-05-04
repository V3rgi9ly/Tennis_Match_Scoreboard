package repository;

import model.Players;
import model.PlayersCurrentMathes;
import model.StoringCurrentMatches;
import org.hibernate.Session;
import util.ConfigurationData;
import util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class PlayersDAO {

    HibernateUtil configHibernate = HibernateUtil.getInstance();
    ConfigurationData configurationData=ConfigurationData.getInstance();

    public boolean findPlayers(String nameOne, String nameTwo) {


        Session session = configHibernate.configurationHibernate().getCurrentSession();

        try {
            session.beginTransaction();

            session.createQuery("from Players where name=man and name='sdfdsf'")


            session.getTransaction().commit();
        } finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }

    }

    public PlayersCurrentMathes addCurrentMathes(Players players, Players players2){
        Session session = configHibernate.configurationHibernate().openSession();
        PlayersCurrentMathes currentMathes=null;
        UUID uuid = UUID.randomUUID();
        configurationData.collectionCuurentMathes.put(uuid, currentMathes);

        try {
            session.beginTransaction();
            Players playersOne=players;
            Players playersTwo=players2;

            currentMathes=new PlayersCurrentMathes(playersOne.getId(), playersTwo.getId(), 0,0,0,0,0,0);
            StoringCurrentMatches storingCurrentMatches=new StoringCurrentMatches(uuid, currentMathes.toString());


            session.save(playersOne);
            session.save(playersTwo);
            session.save(storingCurrentMatches);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }

        return currentMathes;
    }


    public void updateCurrentMathes() {


    }
}
