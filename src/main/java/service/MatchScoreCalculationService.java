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
        match1 = collectingPoints(match1, score);
        config.collectionCuurentMathes.put(uuid, match1);

        return playersMapper.matchDTO(match1);

    }

    private Match collectingPoints(Match match, String score) {
        match = calculateMatchScorePoint(match, score);
        calculateMatchScoreGames(match, score);
    }

    private void calculateMatchScorePoint(Match match, String score) {

        if (score.equals("ScoreOne")) {
            if (match.getPointScorePlayerOne() == 30) {
                match.setPointScorePlayerOne(match.getPointScorePlayerOne() + 10);
            } else {
                match.setPointScorePlayerOne(match.getPointScorePlayerOne() + 15);
                if (match.getPointScorePlayerOne() > 40) {
                    match.setPointScorePlayerOne(match.getPointScorePlayerOne() * 0);
                    calculateMatchScoreGames(match, score);
                }
            }
        } else if (score.equals("ScoreTwo")) {
            if (match.getPointScorePlayerTwo() == 30) {
                match.setPointScorePlayerTwo(match.getPointScorePlayerTwo() + 10);

            } else {
                match.setPointScorePlayerTwo(match.getPointScorePlayerTwo() + 15);
                if (match.getPointScorePlayerTwo() > 40) {
                    match.setPointScorePlayerTwo(match.getPointScorePlayerTwo() * 0);
                    calculateMatchScoreGames(match, score);

                }
            }

        }

    }

    private void calculateMatchScoreGames(Match match, String score) {

        if (match.getGamesScorePlayerOne() > match.getGamesScorePlayerTwo() && match.getGamesScorePlayerOne() == 6) {
            match.setSetScorePlayerOne(match.getSetScorePlayerOne() + 1);
        } else if (match.getGamesScorePlayerTwo() > match.getGamesScorePlayerOne() && match.getGamesScorePlayerTwo() == 6) {
            match.setSetScorePlayerTwo(match.getSetScorePlayerTwo() + 1);
        } else if (match.getGamesScorePlayerTwo() == match.getGamesScorePlayerOne() && match.getGamesScorePlayerTwo() == 6 && match.getGamesScorePlayerOne() == 6) {
            calculateMatchScoreGamesTimeBreak(match, score);
        } else {
            if (score.equals("ScoreOne")) {
                match.setGamesScorePlayerOne(match.getGamesScorePlayerOne() + 1);
            } else if (score.equals("ScoreTwo")) {
                match.setGamesScorePlayerTwo(match.getGamesScorePlayerTwo() + 1);
            }
        }
    }

    private void calculateMatchScoreGamesTimeBreak(Match match, String score) {
        if (score.equals("ScoreOne")) {
            match.setGamesScorePlayerOne(match.getGamesScorePlayerOne() + 1);
            calculateMatchScoreSet(match, score);
        } else if (score.equals("ScoreTwo")) {
            match.setGamesScorePlayerTwo(match.getGamesScorePlayerTwo() + 1);
            calculateMatchScoreSet(match, score);
        }
    }

    private void calculateMatchScoreSet(Match match, String score) {

        if (match.getSetScorePlayerOne() == 2) {

        } else if (match.getSetScorePlayerTwo() == 2) {

        } else {
            if (score.equals("ScoreOne")) {
                match.setSetScorePlayerOne(match.getSetScorePlayerOne() + 1);
                match.setGamesScorePlayerOne(match.getGamesScorePlayerOne() * 0);
            } else if (score.equals("ScoreTwo")) {
                match.setSetScorePlayerTwo(match.getSetScorePlayerTwo() + 1);
                match.setGamesScorePlayerTwo(match.getGamesScorePlayerTwo() * 0);
            }
        }
    }
}
