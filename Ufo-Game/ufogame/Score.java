package ufogame;

import java.io.Serializable;
/*
 * This Class is made to be instantiated once and then directly saved to the Highscore Class.
 * This Score can be printed and compared, but cannot be changed later on.  
 */
public class Score implements Comparable<Score>, Serializable{

	private String playerName;
	private int score = 0;
	
	/*
	 * For Future enhancements of the score Object. 
	 */
	private int shotsFired = 0;
	private int hitTargets = 0;
	private int timeInSecs = 0;
		
	Score(String playerName, int score) {
		this.playerName = playerName;
		this.score = score;
	}
	
	Score(String playerName, int shotsFired, int hitTargets, int timeInSec) {
		this.playerName = playerName;
		/*
		 * TODO: This could be an alternative Score with more informations about what the Player actually reached.
		 * But it should be considered how the objects will be compared then. 
		 */
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getScore() {
		return score;
	}
	
	public void printScore() {
		System.out.println("Sorry :( This has not been implemented yet.");
	}

	@Override
	public int compareTo(Score o) {
		if (o.score > this.score ) {
			return -1;
		} else if (o.score < this.score) {
			return 1;
		} else {
			return 0;
		}
	}
}
