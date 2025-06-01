package repository;

import model.Match;
import model.Matches;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class MathesRepository implements InterfaceMathesRepository {
    HibernateUtil configHibernate = HibernateUtil.getInstance();
//    ConfigurationData configurationData=ConfigurationData.getInstance();

    @Override
    public void save(Match values) {
        Session session = configHibernate.configurationHibernate().getCurrentSession();
        try {
            session.beginTransaction();
            Matches matches = new Matches();
            matches.setPlayer1(values.getPlayersOne());
            matches.setPlayer2(values.getPlayer2());
            matches.setWinner(values.getWinner());

            session.save(matches);
            session.getTransaction().commit();

        } finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }
    }

    @Override
    public List<Matches> findAll(int val1, int val2) {

        List<Matches> matches = new ArrayList<>();
        Session session = configHibernate.configurationHibernate().getCurrentSession();
        try {

            session.beginTransaction();
            Query<Matches> query = session.createQuery("from Matches ");
            query.setFirstResult(val1);
            query.setMaxResults(val2);

            matches = query.list();
            session.getTransaction().commit();

        } finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }
        return matches;
    }

    @Override
    public List find(String val1) {
        return List.of();
    }

    @Override
    public void update() {

    }

    public Long getCountInTable() {
        Session session = configHibernate.configurationHibernate().getCurrentSession();

        Long query;

        try {
            session.beginTransaction();
            query = (Long)session.createQuery("select count(*) from Matches").getSingleResult();


            session.getTransaction().commit();
        } finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }
        return query;
    }
}
