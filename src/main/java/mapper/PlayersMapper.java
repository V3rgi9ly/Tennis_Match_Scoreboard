package mapper;

import dto.PlayersCurrentMatchesDTO;
import dto.PlayersDTO;
import model.Players;
import model.PlayersCurrentMathes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayersMapper {

    PlayersMapper INSTANCE= Mappers.getMapper(PlayersMapper.class);

    PlayersCurrentMatchesDTO playersCurrentMathesDTO(PlayersCurrentMathes playersCurrentMathes);
    PlayersCurrentMathes playersCurrentMathesDTO(PlayersCurrentMatchesDTO playersCurrentMathes);
    Players players(PlayersDTO playersDTO);

}
