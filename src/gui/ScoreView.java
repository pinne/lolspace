/*
 * ScoreView
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.*;

import lolspace.GameWorld;

/**
 * 
 * @author simon
 * 
 */
public class ScoreView extends JPanel implements Observer {

    private static final long serialVersionUID = 4108750243244518957L;
    private static final Random RANDOM = new Random();
    private JLabel scoresLabel;
    private JLabel quotesLabel;
    private static final String[] quotes = { "you are beautiful",
            "you are doing great", "", "<3", ":-)", ";)", "super",
            "GOGOGOGO!!!", "great move!", "let's go!", "stay positive",
            "keep it up", ":D", "a lol a day", "thx 4 being u",
            "you are loved", "find a friend in everyone" };
    private static final String[] almostGOquotes = { "watch out!",
            "do not want", "whoa!!", "be careful", "holy moly" };

    private Color myBackground;

    public ScoreView(GameWorld gw) {
        gw.addObserver(this);

        Color midnightblue = new Color(25, 25, 112);
        this.setForeground(midnightblue);

        Color gainsboro = new Color(220, 220, 220);
        this.myBackground = gainsboro;
        this.setBackground(myBackground);

        scoresLabel = new JLabel("Score: ");
        quotesLabel = new JLabel("");

        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        this.setPreferredSize(new Dimension(100, 42));
        this.add(scoresLabel);
        this.add(quotesLabel);
        this.update(gw, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        int score;
        GameWorld gw = (GameWorld) o;
        score = gw.getScore();
        scoresLabel.setText("Score: " + score);

        if (gw.isGameOver() || !gw.isRunning()) {
            quotesLabel.setText("game over idiot");
        } else if (gw.almostGameOver()) {
            this.setBackground(Color.LIGHT_GRAY);
            quotesLabel.setText("" + almostGOtext());
        } else {
            quotesLabel.setText("" + quotesText());
            this.setBackground(myBackground);
        }
    }

    private String quotesText() {
        return quotes[RANDOM.nextInt(quotes.length)];
    }
    
    private String almostGOtext () {
        return almostGOquotes[RANDOM.nextInt(almostGOquotes.length)];
    }
}