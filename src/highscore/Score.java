/*
 * Score
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package highscore;

import java.io.Serializable;

public class Score implements Serializable, Comparable<Score> {

    private static final long serialVersionUID = 1702003941740999636L;
    private int score;
    private String name;

    public Score(String name, int score) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Score score1) {
        return ((Integer) (score1.getScore())).compareTo(getScore());
    }
}