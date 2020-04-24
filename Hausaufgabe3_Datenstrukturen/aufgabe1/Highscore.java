package aufgabe1;

public class Highscore {

	private String playername;
	private int score;
	
	public Highscore(String playername, int score) {
		this.playername = playername;
		this.score = score;
	}

	public String getPlayername() {
		return playername;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
