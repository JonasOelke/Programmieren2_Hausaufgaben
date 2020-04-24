package aufgabe2;

public class Highscore implements Comparable<Highscore> {

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

	@Override
	public int compareTo(Highscore o) {
		if (score > o.getScore()) return 1;
		else if ( score < o.getScore()) return -1;
		else return 0;
	}

}
