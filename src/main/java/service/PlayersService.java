package service;

import model.Players;
import repository.PlayersRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayersService {

    private PlayersRepository playersRepository;

    public PlayersService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }


    public void findPlayer(String playerOne, String playerTwo) {
        String name1 = "";
        String name2 = "";
        for (Players players : playersRepository.find(playerOne)) {
            name1 = players.getName();
        }
        for (Players players : playersRepository.find(playerTwo)) {
            name2 = players.getName();
        }

        if (!name1.equals(playerOne) && name2.equals(playerTwo)) {
            createPlayer(playerOne);

        } else if (name1.equals(playerOne) && !name2.equals(playerTwo)) {
            createPlayer(playerTwo);

        } else if (!name1.equals(playerTwo) && !name2.equals(playerOne)) {
            createPlayers(playerOne, playerTwo);
        }
    }


    private void createPlayer(String name1) {
        playersRepository.create(name1);
    }

    private void createPlayers(String name1, String name2) {
        playersRepository.create(name1, name2);
    }


}
