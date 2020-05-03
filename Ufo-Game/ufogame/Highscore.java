package ufogame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Highscore implements Serializable {
	private ArrayList<Score> scoresList = new ArrayList<Score>();
	
	public void addScore(Score score) {
		scoresList.add(score);
		Collections.sort(scoresList);
	}
	
	public ArrayList<Score> getScores() {
		return scoresList;
	}
	
	public void printScores() {
		for (Score score : scoresList) {
			System.out.println(score.getScore() + "\t" + score.getPlayerName());
		}
	}
}
