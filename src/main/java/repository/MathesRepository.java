package repository;

import model.Match;
import model.Matches;
import org.hibernate.Session;
import util.ConfigurationData;
import util.HibernateUtil;

import java.util.List;

public class MathesRepository implements  InterfaceMathesRepository {
    HibernateUtil configHibernate = HibernateUtil.getInstance();
//    ConfigurationData configurationData=ConfigurationData.getInstance();

    @Override
    public void save(Match values) {

        try (Session session = configHibernate.configurationHibernate().getCurrentSession()) {
            session.beginTransaction();
            Matches matches = new Matches();
            matches.setPlayer1(values.getPlayersOne());
            matches.setPlayer2(values.getPlayersTwo());
            matches.setWinner(values.getWinner());

            session.save(matches);
            session.getTransaction().commit();

        } finally {
            configHibernate.configurationHibernate().close();
        }
    }

    @Override
    public List findAll(Object val1, Object val2) {
        return List.of();
    }

    @Override
    public List find(String val1) {
        return List.of();
    }

    @Override
    public void update() {

    }
}
