package mapper;

import dto.MatchDTO;
import dto.PlayersDTO;
import model.Match;
import model.Players;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlayersMapper {

    PlayersMapper INSTANCE= Mappers.getMapper(PlayersMapper.class);

    Players players(PlayersDTO playersDTO);
    Match matchs(MatchDTO matchDTO);
    MatchDTO matchDTO(Match match);
    List<Match> match(List<Players> players);




}
