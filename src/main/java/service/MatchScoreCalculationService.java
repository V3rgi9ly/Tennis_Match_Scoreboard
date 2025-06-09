package service;

import dto.MatchDTO;
import mapper.PlayersMapper;
import model.Match;
import util.ConfigurationData;
import util.ParseVariableMatch;

import java.util.UUID;

public class MatchScoreCalculationService {

    private ParseVariableMatch parseVariableMatch;
    private PlayersMapper playersMapper = PlayersMapper.INSTANCE;
    private ConfigurationData config;


    public MatchScoreCalculationService(ParseVariableMatch parseVariableMatch) {
        this.parseVariableMatch = parseVariableMatch;
    }

    public MatchScoreCalculationService() {
        parseVariableMatch = new ParseVariableMatch();
        config = ConfigurationData.getInstance();

    }

    public MatchDTO calculateMatchScore(String score, UUID uuid) {
        Match match1 = config.collectionCuurentMathes.get(uuid);
        match1 = collectingPointInMatch(match1, score);
        config.collectionCuurentMathes.put(uuid, match1);

        return playersMapper.matchDTO(match1);

    }


    public Match collectingPointInMatch(Match match, String score) {
        if (parseVariableMatch.getB() == parseVariableMatch.getA() && parseVariableMatch.getB() == 40 && parseVariableMatch.getA() == 40) {
            match = advantage(match, score);
            match.setAdvantage(true);
        } else if (match.isAdvantage() == true) {
            match = advantage(match, score);
        } else if ((match.getGamesScorePlayerTwo() == 5 && match.getGamesScorePlayerOne() == 5)) {
            match = calculateMatchScorePoint(match, score);
            match = parseVariableMatch.parsePointScore(match);
            match.setSetTiedAtFive(true);
            match = calculateSetTiedAtFive(match, score);
        } else if (match.isSetTiedAtFive() == true) {
            match = calculateMatchScorePoint(match, score);
            match = parseVariableMatch.parsePointScore(match);
            match = calculateSetTiedAtFive(match, score);

        } else if (match.isTieBreak()==true) {
            match=MatchScoreGamesTieBreak(match, score);
            match = parseVariableMatch.parsePointScore(match);
            
        } else if (match.isTieBreak() == false) {
            match = calculateMatchScorePoint(match, score);
            if (match.getGamesScorePlayerOne() > match.getGamesScorePlayerTwo() && match.getGamesScorePlayerOne() == 6) {
                match = calculateMatchScoreSet(match, score);
            } else if (match.getGamesScorePlayerTwo() > match.getGamesScorePlayerOne() && match.getGamesScorePlayerTwo() == 6) {
                match = calculateMatchScoreSet(match, score);
            }
            match = parseVariableMatch.parsePointScore(match);
        }


        return match;
    }


    private Match calculateMatchScorePoint(Match match, String score) {

        if (score.equals("ScoreOne")) {
            if (parseVariableMatch.getA() == 30) {
                parseVariableMatch.setA(parseVariableMatch.getA() + 10);
            } else {
                parseVariableMatch.setA(parseVariableMatch.getA() + 15);
                if (parseVariableMatch.getA() > 40) {
                    parseVariableMatch.setA(parseVariableMatch.getA() * 0);
                    parseVariableMatch.setB(parseVariableMatch.getB() * 0);
                    match = calculateMatchScoreGames(match, score);
                }
            }
        } else if (score.equals("ScoreTwo")) {
            if (parseVariableMatch.getB() == 30) {
                parseVariableMatch.setB(parseVariableMatch.getB() + 10);

            } else {
                parseVariableMatch.setB(parseVariableMatch.getB() + 15);
                if (parseVariableMatch.getB() > 40) {
                    parseVariableMatch.setA(parseVariableMatch.getA() * 0);
                    parseVariableMatch.setB(parseVariableMatch.getB() * 0);
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


    private Match advantage(Match match, String score) {

        if (match.getPointScorePlayerOne() == match.getPointScorePlayerTwo() && match.getPointScorePlayerOne().equals("AD") && match.getPointScorePlayerTwo().equals("AD")) {

            if (score.equals("ScoreOne")) {
                match = calculateMatchScoreGames(match, score);

                match.setPointScorePlayerOne("0");
                match.setPointScorePlayerTwo("0");
                match.setAdvantage(false);

            } else if (score.equals("ScoreTwo")) {
                match = calculateMatchScoreGames(match, score);

                match.setPointScorePlayerOne("0");
                match.setPointScorePlayerTwo("0");
                match.setAdvantage(false);
            }

        } else if (checkingTheConditionAdvantage(match, score)) {
            if (score.equals("ScoreOne")) {
                match.setPointScorePlayerOne("AD");
                parseVariableMatch.setA(parseVariableMatch.getA() * 0);
            } else if (score.equals("ScoreTwo")) {
                match.setPointScorePlayerTwo("AD");
                parseVariableMatch.setB(parseVariableMatch.getB() * 0);

            }

        } else {
            if (score.equals("ScoreOne")) {
                match.setPointScorePlayerOne("0");
                match.setPointScorePlayerTwo("0");
                parseVariableMatch.setA(parseVariableMatch.getA() * 0);
                parseVariableMatch.setB(parseVariableMatch.getB() * 0);
                match = calculateMatchScoreGames(match, score);
                match.setAdvantage(false);


            } else if (score.equals("ScoreTwo")) {
                match.setPointScorePlayerOne("0");
                match.setPointScorePlayerTwo("0");
                parseVariableMatch.setA(parseVariableMatch.getA() * 0);
                parseVariableMatch.setB(parseVariableMatch.getB() * 0);
                match = calculateMatchScoreGames(match, score);
                match.setAdvantage(false);


            }
        }

        return match;
    }


    private Match calculateSetTiedAtFive(Match match, String score) {

        if (match.getGamesScorePlayerOne() == 6 && match.getGamesScorePlayerTwo() == 6) {
            match.setSetTiedAtFive(false);
            match.setTieBreak(true);
        }else if (match.getGamesScorePlayerOne()-2==match.getGamesScorePlayerTwo()) {
            match.setSetTiedAtFive(false);
            match = calculateMatchScoreSet(match, score);
        } else if (match.getGamesScorePlayerTwo()-2==match.getGamesScorePlayerOne()) {
            match.setSetTiedAtFive(false);
            match = calculateMatchScoreSet(match, score);
        }

        return match;
    }


    private Match MatchScoreGamesTieBreak(Match match, String score) {

        if(parseVariableMatch.getA()-2==parseVariableMatch.getB() || parseVariableMatch.getB()-2==parseVariableMatch.getA()){
            parseVariableMatch.setA(parseVariableMatch.getA() * 0);
            parseVariableMatch.setB(parseVariableMatch.getB() * 0);
            match.setPointScorePlayerOne("0");
            match.setPointScorePlayerTwo("0");
            match = calculateMatchScoreSet(match, score);
            match.setTieBreak(false);
        }else {
            match = calculateMatchScoreGamesTieBreak(match, score);
        }
        return match;
    }

    private Match calculateMatchScoreGamesTieBreak(Match match, String score){
        if (score.equals("ScoreOne")) {
            parseVariableMatch.setA(parseVariableMatch.getA() + 1);
        }
        else if (score.equals("ScoreTwo")) {
            parseVariableMatch.setB(parseVariableMatch.getB() + 1);
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

    private boolean checkingTheConditionAdvantage(Match match, String score) {
        if (score.equals("ScoreOne")) {
            if (match.getPointScorePlayerOne().equals("AD")) {
                return false;
            }

        } else if (score.equals("ScoreTwo")) {
            if (match.getPointScorePlayerTwo().equals("AD")) {
                return false;
            }
        }

        return true;
    }

}
