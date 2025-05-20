package service;

import dto.MatchDTO;
import mapper.PlayersMapper;
import model.Match;
import util.ConfigurationData;

import java.util.UUID;

public class StorageIdMatchService {

    private ConfigurationData config;
    private PlayersMapper playersMapper=PlayersMapper.INSTANCE;

    public StorageIdMatchService(){
        config = ConfigurationData.getInstance();
    }

    public MatchDTO getMathes(UUID uuid) {
      Match match=config.collectionCuurentMathes.get(uuid);
      return playersMapper.matchDTO(match);
    }
}
