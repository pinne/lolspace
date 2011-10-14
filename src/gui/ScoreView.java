/*
 * ScoreView
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package gui;

import java.awt.*;

import javax.swing.*;

import collapse.GameWorld;

/**
 * 
 * @author simon
 *
 */
public class ScoreView extends JPanel {

    private static final long serialVersionUID = 4108750243244518957L;
    private GameWorld world;
    private JLabel scoresLabel;
    
    public ScoreView(GameWorld world) {
        this.world = world;
        Color midnightblue = new Color(25, 25, 112);
        this.setForeground(midnightblue);
        Color gainsboro = new Color(220, 220, 220);
        this.setBackground(gainsboro);
        scoresLabel = new JLabel("Score: ");
        this.setPreferredSize(new Dimension(56, 32));
        this.add(scoresLabel);
    }
    
    public void updateScore() {
        int score;
        score = world.getScore();
        scoresLabel.setText("Score: " + score);
    }
}