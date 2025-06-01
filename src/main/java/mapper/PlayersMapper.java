package mapper;

import dto.MatchDTO;
import dto.MathesDTO;
import dto.PlayersDTO;
import model.Match;
import model.Matches;
import model.Players;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlayersMapper {

    PlayersMapper INSTANCE= Mappers.getMapper(PlayersMapper.class);

    PlayersDTO players(Players players);
    Match match(MatchDTO matchDTO);
    MatchDTO matchDTO(Match match);
    List<Match> matchList(List<Players> players);
    List<Match> mathes(List<Matches> matches);
    List<MathesDTO> mathesDTO(List<Match> matches);
   List<MathesDTO> matchesList(List<Matches> matches);




}
