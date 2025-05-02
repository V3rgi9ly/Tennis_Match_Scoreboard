package service;

import dto.PlayersCurrentMatchesDTO;
import repository.PlayersDAO;

public class ServicesStoringCurrentMatches {
    private PlayersDAO playersDAO=new PlayersDAO();

    public void createCurrentMatch(){
        PlayersCurrentMatchesDTO playersCurrentMatchesDTO=new PlayersCurrentMatchesDTO();
        playersDAO.addCurrentMathes();
    }
}
