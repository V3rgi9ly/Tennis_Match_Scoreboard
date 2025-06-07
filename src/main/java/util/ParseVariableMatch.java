package util;

import model.Match;

public class ParseVariableMatch {

    private int a;
    private int b;


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Match parsePointScore(Match match) {
        match.setPointScorePlayerOne(String.valueOf(a));
        match.setPointScorePlayerTwo(String.valueOf(b));
        return match;
    }

}
