package repository;

import mapper.PlayersMapper;
import model.Match;
import model.Players;
import org.hibernate.Session;
import util.ConfigurationData;
import util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class LocalRepository implements InterfaceLocalRepository<Match> {

    HibernateUtil configHibernate = HibernateUtil.getInstance();
    ConfigurationData configurationData = ConfigurationData.getInstance();
    private  final PlayersMapper playersMapper=PlayersMapper.INSTANCE;


    @Override
    public Match create(String val1, String val2) {
        Session session = configHibernate.configurationHibernate().openSession();
        List<Players> players1;
        Match match = null;

        try {
            session.beginTransaction();
            players1 = session.createQuery("from Players where name in (:val1, :val2)").list();
            session.getTransaction().commit();
        } finally {
            session.close();
            configHibernate.configurationHibernate().close();
        }

        match.setPlayersOne(players1.get(0));
        match.setPlayersTwo(players1.get(1));
        match.setGamesScorePlayerOne(0);
        match.setGamesScorePlayerTwo(0);
        match.setSetScorePlayerOne(0);
        match.setSetScorePlayerTwo(0);
        match.setPointScorePlayerOne(0);
        match.setPointScorePlayerTwo(0);

        configurationData.collectionCuurentMathes.put(UUID.randomUUID(), match);

        return match;
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
