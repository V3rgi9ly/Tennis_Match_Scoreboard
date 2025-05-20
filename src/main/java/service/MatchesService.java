package service;

import dto.MatchDTO;
import mapper.PlayersMapper;
import model.Match;
import model.Players;
import repository.LocalRepository;
import repository.PlayersRepository;
import util.ConfigurationData;
import util.ConfigurationRepository;

import java.util.*;

public class MatchesService {

    ConfigurationRepository configurationRepository = ConfigurationRepository.getInstance();
    //    private LocalRepository localRepository = new LocalRepository();
    //    private PlayersRepository playersRepository=new PlayersRepository();
    private ConfigurationData configurationData = ConfigurationData.getInstance();
    private final PlayersMapper playersMapper = PlayersMapper.INSTANCE;

    public MatchesService() {
        configurationRepository.getLocalRepository();
        configurationRepository.getPlayersRepository();
    }

    public UUID createCurrentMatch(String namePlayerOne, String namePlayerTwo) {
        Match match1 = new Match();
        List<Players> players = configurationRepository.getLocalRepository().create(namePlayerOne, namePlayerTwo);

        match1.setPlayersOne(players.get(0));
        match1.setPlayersTwo(players.get(1));
        match1.setGamesScorePlayerOne(0);
        match1.setGamesScorePlayerTwo(0);
        match1.setSetScorePlayerOne(0);
        match1.setSetScorePlayerTwo(0);
        match1.setPointScorePlayerOne(0);
        match1.setPointScorePlayerTwo(0);

        UUID uuid = UUID.randomUUID();
        configurationData.collectionCuurentMathes.put(uuid, match1);

        return uuid;
    }

    public MatchDTO getCurrentMatch(UUID uuid) {
        Match match = configurationData.collectionCuurentMathes.get(uuid);
        return playersMapper.matchDTO(match);
    }





}
