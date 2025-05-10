package service;

import dto.MatchDTO;
import mapper.PlayersMapper;
import model.Match;
import model.Players;
import repository.LocalRepository;
import repository.PlayersRepository;
import util.ConfigurationRepository;

public class MatchesService {

    ConfigurationRepository configurationRepository=ConfigurationRepository.getInstance();
//    private LocalRepository localRepository = new LocalRepository();
    //    private PlayersRepository playersRepository=new PlayersRepository();
//    private final PlayersMapper playersMapper = PlayersMapper.INSTANCE;

    public MatchesService() {
        configurationRepository.getLocalRepository();
        configurationRepository.getPlayersRepository();
    }

    public String createCurrentMatch(String namePlayerOne, String namePlayerTwo) {
        String id = configurationRepository.getLocalRepository().create(namePlayerOne, namePlayerTwo);
        return id;
    }

}
