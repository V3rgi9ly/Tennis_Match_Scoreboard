package service;

import model.Players;
import util.ConfigurationRepository;

import java.util.List;

public class PlayersService {


    ConfigurationRepository configurationRepository = ConfigurationRepository.getInstance();

    public PlayersService() {
        configurationRepository.getPlayersRepository();
    }


    public void findPlayer(String playerOne, String playerTwo) {
        Players players1 = new Players();
        players1.setName(playerOne);

        Players players2 = new Players();
        players2.setName(playerTwo);

        List<Players> players3 =configurationRepository.getPlayersRepository().find(playerOne);
        List<Players> players4 =configurationRepository.getPlayersRepository().find(playerTwo);

            if (players3.size()==0 && players4.size()==0) {
                createPlayer(playerOne);
                createPlayer(playerTwo);
            }
            else if ((players3.size()!=0 && players4.size()==0)){
                createPlayer(playerTwo);
            }else if ((players3.size()==0 && players4.size()!=0)){
                createPlayer(playerOne);
            }

    }


    private void createPlayer(String name1) {
        configurationRepository.getPlayersRepository().create(name1);
    }



}
