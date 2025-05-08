package service;

import dto.MatchDTO;
import mapper.PlayersMapper;
import model.Match;
import model.Players;
import repository.LocalRepository;
import repository.PlayersRepository;

public class MatchesService {

    private LocalRepository localRepository;
    private PlayersRepository playersRepository;
    private final PlayersMapper playersMapper=PlayersMapper.INSTANCE;

    public MatchesService(LocalRepository localRepository, PlayersRepository playersRepository) {
        this.localRepository = localRepository;
        this.playersRepository = playersRepository;
    }

    public MatchDTO createCurrentMatch(String namePlayerOne, String namePlayerTwo) {
        Match match=localRepository.create(namePlayerOne,namePlayerTwo);
        return playersMapper.matchDTO(match);
    }

}
