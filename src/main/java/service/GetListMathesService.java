package service;

import dto.MathesDTO;
import mapper.PlayersMapper;
import model.Match;
import model.Matches;
import util.ConfigurationRepository;

import java.util.ArrayList;
import java.util.List;

public class GetListMathesService {

    private ConfigurationRepository repository = ConfigurationRepository.getInstance();
    private PlayersMapper playersMapper = PlayersMapper.INSTANCE;

    public GetListMathesService() {

    }

    public List<MathesDTO> getListMathes(int page) {
        List<MathesDTO> mathesDTOS=playersMapper.matchesList(repository.getMathesRepository().findAll((page*5)-5, 5));
        return mathesDTOS;
    }


    public List<Integer> getListPages(){
        Long page=repository.getMathesRepository().getCountInTable();

        page=(page+5-1)/5;
        List<Integer> pages=new ArrayList<Integer>();
        for (int i=1; i<=page; i++) {
            pages.add(i);
        }
        return pages;
    }

    public List<Integer> getListPages(String val1){
        Long page=repository.getMathesRepository().getCountInTable(val1);

        page=(page+5-1)/5;
        List<Integer> pages=new ArrayList<Integer>();
        for (int i=1; i<=page; i++) {
            pages.add(i);
        }
        return pages;
    }
}
