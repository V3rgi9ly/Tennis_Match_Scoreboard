package service;

import dto.PlayersCurrentMatchesDTO;
import dto.PlayersDTO;
import mapper.PlayersMapper;
import model.Players;
import repository.PlayersDAO;

public class ServicesStoringCurrentMatches {
    private final PlayersDAO playersDAO=new PlayersDAO();
    private final PlayersMapper playersMapper=PlayersMapper.INSTANCE;
    PlayersCurrentMatchesDTO playersCurrentMatchesDTO=new PlayersCurrentMatchesDTO();

    public PlayersCurrentMatchesDTO createCurrentMatch(String name, String name2){
        PlayersDTO playersOne=new PlayersDTO(name);
        PlayersDTO playersTwo=new PlayersDTO(name2);
        Players players=playersMapper.players(playersOne);
        Players players2=playersMapper.players(playersTwo);
        playersCurrentMatchesDTO=playersMapper.playersCurrentMathesDTO(playersDAO.addCurrentMathes(players, players2));
        return playersCurrentMatchesDTO;
    }
}
