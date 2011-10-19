/*
 * HighScore
 * 
 * Copyright Simon Kers - KTH 2011.
 */
package highscore;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import gui.MainPanel;

public class HighScore {

    private MainPanel panel;
    private ArrayList<Score> highscore;
    private static final String HIGHSCORE_FILE = "lolspace.highscore";
    private String defaultName;
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighScore(MainPanel panel) {
        this.panel = panel;
        highscore = new ArrayList<Score>();
        defaultName = new String("xyzzy");
    }

    public ArrayList<Score> getHighScore() {
        return highscore;
    }

    public void addScore(String name, int pts) {
        loadScoreFile();
        highscore.add(new Score(name, pts));
        updateScoreFile();
    }

    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return highscore;
    }

    private void sort() {
        Collections.sort(highscore);
    }

    @SuppressWarnings("unchecked")
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(
                    HIGHSCORE_FILE));
            highscore = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            this.updateScoreFile();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(), "IO Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(),
                    "ClassNotFound Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(panel, e.getMessage(),
                        "IO Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(
                    HIGHSCORE_FILE));
            outputStream.writeObject(highscore);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(),
                    "File Not Found", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(), "IO Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(panel, e.getMessage(),
                        "IO Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getHighscoreString() {
        String highscoreString = "";
        int max = 10;

        ArrayList<Score> highscore;
        highscore = getScores();

        int i = 0;
        int x = highscore.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + "\t" + highscore.get(i).getName()
                    + "\t" + highscore.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
    }

    public void gameOver(int myScore) {
        if (madeTheList(myScore)) {
            enterName(myScore);
        }
    }

    private boolean madeTheList(int myScore) {
        boolean madeIt = false;

        if (highscore.isEmpty()) {
            madeIt = true;
        }

        for (Score s : highscore) {
            if (myScore > s.getScore()) {
                madeIt = true;
                break;
            }
        }

        return madeIt;
    }

    private void enterName(int myScore) {
        String name = JOptionPane.showInputDialog(panel, "Enter you name",
                defaultName);
        
        defaultName = name;
        addScore(name, myScore);
        this.sort();
        this.updateScoreFile();
    }
}
