package service;

import dto.MatchDTO;
import mapper.PlayersMapper;
import model.Match;
import util.ConfigurationData;

import java.util.UUID;

public class MatchScoreCalculationService {

    private PlayersMapper playersMapper = PlayersMapper.INSTANCE;
    private ConfigurationData config;

    public MatchScoreCalculationService() {
        config = ConfigurationData.getInstance();
    }

    public MatchDTO calculateMatchScore(MatchDTO match, String score, UUID uuid) {
        Match match1 = config.collectionCuurentMathes.get(uuid);
        match1 = collectingPointInMatch(match1, score);
        config.collectionCuurentMathes.put(uuid, match1);

        return playersMapper.matchDTO(match1);

    }

    private Match collectingPointInMatch(Match match, String score) {

        match = calculateMatchScorePoint(match, score);

        if ((match.getGamesScorePlayerTwo() == 5 && match.getGamesScorePlayerOne() == 5) || match.isTimeBreak() == true) {
            match = calculateMatchScoreGamesTimeBreak(match, score);
            match.setTimeBreak(true);
        } else if (match.isTimeBreak() == false) {
            if (match.getGamesScorePlayerOne() > match.getGamesScorePlayerTwo() && match.getGamesScorePlayerOne() == 6) {
                match = calculateMatchScoreSet(match, score);
            } else if (match.getGamesScorePlayerTwo() > match.getGamesScorePlayerOne() && match.getGamesScorePlayerTwo() == 6) {
                match = calculateMatchScoreSet(match, score);
            }
        }

        return match;
    }

    private Match calculateMatchScorePoint(Match match, String score) {

        if (score.equals("ScoreOne")) {
            if (match.getPointScorePlayerOne() == 30) {
                match.setPointScorePlayerOne(match.getPointScorePlayerOne() + 10);
            } else {
                match.setPointScorePlayerOne(match.getPointScorePlayerOne() + 15);
                if (match.getPointScorePlayerOne() > 40) {
                    match.setPointScorePlayerOne(match.getPointScorePlayerOne() * 0);
                    match.setPointScorePlayerTwo(match.getPointScorePlayerTwo() * 0);
                    match = calculateMatchScoreGames(match, score);
                }
            }
        } else if (score.equals("ScoreTwo")) {
            if (match.getPointScorePlayerTwo() == 30) {
                match.setPointScorePlayerTwo(match.getPointScorePlayerTwo() + 10);

            } else {
                match.setPointScorePlayerTwo(match.getPointScorePlayerTwo() + 15);
                if (match.getPointScorePlayerTwo() > 40) {
                    match.setPointScorePlayerTwo(match.getPointScorePlayerTwo() * 0);
                    match.setPointScorePlayerOne(match.getPointScorePlayerOne() * 0);
                    match = calculateMatchScoreGames(match, score);
                }
            }
        }
        return match;
    }

    private Match calculateMatchScoreGames(Match match, String score) {
        if (score.equals("ScoreOne")) {
            match.setGamesScorePlayerOne(match.getGamesScorePlayerOne() + 1);
        } else if (score.equals("ScoreTwo")) {
            match.setGamesScorePlayerTwo(match.getGamesScorePlayerTwo() + 1);
        }
        return match;
    }

    private Match calculateMatchScoreGamesTimeBreak(Match match, String score) {

        if (match.getGamesScorePlayerOne() == 7) {
            match = calculateMatchScoreSet(match, score);
            match.setTimeBreak(false);
        } else if (match.getGamesScorePlayerTwo() == 7) {
            match = calculateMatchScoreSet(match, score);
            match.setTimeBreak(false);
        }

        return match;
    }

    private Match calculateMatchScoreSet(Match match, String score) {

        if (score.equals("ScoreOne")) {
            match.setSetScorePlayerOne(match.getSetScorePlayerOne() + 1);
            match.setGamesScorePlayerOne(match.getGamesScorePlayerOne() * 0);
            match.setGamesScorePlayerTwo(match.getGamesScorePlayerTwo() * 0);
        } else if (score.equals("ScoreTwo")) {
            match.setSetScorePlayerTwo(match.getSetScorePlayerTwo() + 1);
            match.setGamesScorePlayerTwo(match.getGamesScorePlayerTwo() * 0);
            match.setGamesScorePlayerOne(match.getGamesScorePlayerOne() * 0);
        }

        match.setGameOver(checkingTheWinningMatch(match));

        return match;
    }

    private boolean checkingTheWinningMatch(Match match) {

        if (match.getSetScorePlayerOne() == 2) {

            match.setWinner(match.getPlayersOne());
            match.setGameOver(true);

        } else if (match.getSetScorePlayerTwo() == 2) {

            match.setWinner(match.getPlayer2());
            match.setGameOver(true);
        }

        return match.isGameOver();
    }

}
