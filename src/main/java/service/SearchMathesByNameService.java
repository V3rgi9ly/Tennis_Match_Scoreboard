package service;

import dto.MathesDTO;
import mapper.PlayersMapper;
import model.Matches;
import util.ConfigurationRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchMathesByNameService {

    private PlayersMapper playersMapper=PlayersMapper.INSTANCE;
    private ConfigurationRepository configurationRepository=ConfigurationRepository.getInstance();

    public SearchMathesByNameService() {
        configurationRepository.getMathesRepository();
    }

    public List<MathesDTO> searchMathesByName(String name, int page){
        List<Matches> matches=configurationRepository.getMathesRepository().findAll(name);
        return playersMapper.matchesList(matches);
    }
}
