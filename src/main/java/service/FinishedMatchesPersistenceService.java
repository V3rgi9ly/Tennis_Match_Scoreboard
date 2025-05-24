package service;

import dto.MatchDTO;
import mapper.PlayersMapper;
import model.Match;
import util.ConfigurationData;
import util.ConfigurationRepository;

import java.util.UUID;

public class FinishedMatchesPersistenceService {

    private ConfigurationData config;
    private ConfigurationRepository repository;
    private PlayersMapper playersMapper = PlayersMapper.INSTANCE;

    public FinishedMatchesPersistenceService() {
        config = ConfigurationData.getInstance();
        repository.getMathesRepository();
    }

    public void saveMatch(MatchDTO matchDTO, UUID playerId) {
        Match match=playersMapper.matchs(matchDTO);

    }
}
