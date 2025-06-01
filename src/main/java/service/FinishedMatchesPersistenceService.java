package service;

import dto.MatchDTO;
import mapper.PlayersMapper;
import model.Match;
import util.ConfigurationData;
import util.ConfigurationRepository;

public class FinishedMatchesPersistenceService {

    private ConfigurationData config;
    private ConfigurationRepository repository=ConfigurationRepository.getInstance();
    private PlayersMapper playersMapper = PlayersMapper.INSTANCE;

    public FinishedMatchesPersistenceService() {
        config = ConfigurationData.getInstance();
        repository.getMathesRepository();
    }

    public void saveMatch(MatchDTO matchDTO) {
        Match match=playersMapper.match(matchDTO);
        repository.getMathesRepository().save(match);

    }
}
