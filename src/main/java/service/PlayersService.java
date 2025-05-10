package service;

import model.Players;
import repository.PlayersRepository;
import util.ConfigurationRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayersService {


    ConfigurationRepository configurationRepository=ConfigurationRepository.getInstance();

    public PlayersService() {
        configurationRepository.getPlayersRepository();
    }


    public void findPlayer(String playerOne, String playerTwo) {
        for (Players players : configurationRepository.getPlayersRepository().find(playerOne)) {
            if (!players.getName().equals(playerOne)) {
                createPlayer(playerOne);
            }
        }
        for (Players players : configurationRepository.getPlayersRepository().find(playerTwo)) {
            if (!players.getName().equals(playerTwo)) {
                createPlayer(playerTwo);
            }
        }
    }


    private void createPlayer(String name1) {
        configurationRepository.getPlayersRepository().create(name1);
    }

//    private void createPlayers(String name1, String name2) {
//        configurationRepository.getPlayersRepository().create(name1, name2);
//    }


}
