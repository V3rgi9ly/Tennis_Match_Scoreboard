package repository;

import mapper.PlayersMapper;
import model.Match;
import model.Players;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.ConfigurationData;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LocalRepository implements InterfaceLocalRepository<Match> {


    HibernateUtil configHibernate = HibernateUtil.getInstance();
//    ConfigurationData configurationData = ConfigurationData.getInstance();


    @Override
    public List<Players> create(String val1, String val2) {
        Session session = configHibernate.configurationHibernate().getCurrentSession();
        List<Players> players1 = new ArrayList<>();

        try {
            session.beginTransaction();
            Query<Players> query = session.createQuery("from Players where name in (:val1, :val2)");
            query.setParameter("val1", val1);
            query.setParameter("val2", val2);
            players1 = query.list();
            session.getTransaction().commit();
        } finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }



        return players1;
    }

    @Override
    public List<Match> findAll(Match val1, Match val2) {
        return null;
    }

    @Override
    public List<Match> find(String val1) {
        return null;
    }

    @Override
    public void update() {

    }
}
