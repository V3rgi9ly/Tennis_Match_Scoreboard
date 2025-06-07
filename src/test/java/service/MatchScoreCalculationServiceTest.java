package service;

import model.Match;
import model.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import util.ParseVariableMatch;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MatchScoreCalculationServiceTest {

    private MatchScoreCalculationService matchScoreCalculationService;
    ParseVariableMatch parseVariableMatch= Mockito.mock(ParseVariableMatch.class);

    @BeforeEach
    public void setUp() {
        matchScoreCalculationService = new MatchScoreCalculationService();
    }


    @Test
    @DisplayName("Test winner game parties")
    public void testWinnerGameParties() {
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 0, 0, "40", "0");
        ParseVariableMatch parseVariableMatch= Mockito.spy(ParseVariableMatch.class);
        parseVariableMatch.setA(40);
        MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService(parseVariableMatch);

        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        int totalGame=match.getGamesScorePlayerOne();
        assertEquals(1, totalGame);

    }

    @Test
    @DisplayName("Test advantage")
    public void testAdvantage(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 0, 0, "40", "40");
        ParseVariableMatch parseVariableMatch= Mockito.spy(ParseVariableMatch.class);
        parseVariableMatch.setA(40);
        parseVariableMatch.setB(40);
        MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService(parseVariableMatch);

        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        boolean advantage=match.isAdvantage();
        assertEquals(true, advantage);

    }

    @Test
    @DisplayName("Test set tied at five")
    public void testSetTiedAtFive(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 5, 5, "0", "0");
        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        boolean setTiedAtFive=match.isSetTiedAtFive();
        assertEquals(true, setTiedAtFive);

    }

    @Test
    @DisplayName("Test tie break")
    public void testTieBreak(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 6, 6, "0", "0");
        match.setSetTiedAtFive(true);
        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        boolean timeBreak=match.isTieBreak();
        assertEquals(true, timeBreak);
    }

    @Test
    @DisplayName("Test successful Operation Set")
    public void testSuccessfulOperationSet(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 6, 5, "30", "0");
        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        int totalSet=match.getSetScorePlayerOne();
        assertEquals(1, totalSet);

    }

    @Test
    @DisplayName("Test game over")
    public void testGameOver(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 1, 1, 6, 5, "30", "0");
        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        boolean gameOver=match.isGameOver();
        assertEquals(true, gameOver);
    }
}
