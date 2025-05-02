package service;

import repository.PlayersDAO;

public class PlayersService {

    private PlayersDAO playersDAO=new PlayersDAO();

    public boolean findPlayer(String playerOne, String playerTwo) {
        playersDAO.findPlayers(playerOne,playerTwo);
    }

    public void createCurrentMatch(){

    }
}
