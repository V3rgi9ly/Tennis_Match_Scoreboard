package service;

import dto.MatchDTO;

import model.Match;
import model.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import util.ConfigurationData;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class MatchScoreCalculationServiceTest {

    private MatchScoreCalculationService matchScoreCalculationService;


    @BeforeEach
    public void setUp() {
        matchScoreCalculationService = new MatchScoreCalculationService();
    }


    @Test
    @DisplayName("Test winner game parties")
    public void testWinnerGameParties() {
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 0, 0, 0, 0);
        match.setPointScorePlayerOne(40);
        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        int totalGame=match.getGamesScorePlayerOne();
        assertEquals(1, totalGame);

    }


    @Test
    @DisplayName("Test time break")
    public void testTimeBreak(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 5, 5, 0, 0);
        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        boolean timeBreak=match.isTimeBreak();
        assertEquals(true, timeBreak);
    }

    @Test
    @DisplayName("Test successful Operation Set")
    public void testSuccessfulOperationSet(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 6, 5, 30, 0);
        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        int totalSet=match.getSetScorePlayerOne();
        assertEquals(1, totalSet);

    }

    @Test
    @DisplayName("Test game over")
    public void testGameOver(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 1, 1, 6, 5, 30, 0);
        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        boolean gameOver=match.isGameOver();
        assertEquals(true, gameOver);
    }
}
