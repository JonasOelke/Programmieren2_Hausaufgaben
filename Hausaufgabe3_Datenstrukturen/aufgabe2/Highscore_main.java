package aufgabe2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Highscore_main {

	public static void main(String[] args) {
		
		ArrayList<Highscore> list = new ArrayList<Highscore>();
		String[] names = {"Claudia","Bob", "Karl", "Alice", "Gustav"};
		Random rand = new Random();
		
		
		for (int i = 0; i < names.length; i++) {
			Highscore score = new Highscore(names[i],rand.nextInt(101));
			list.add(score);
		}
		
		System.out.println("---- SCORES ----");
		for (Highscore score : list) {
			System.out.println(score.getPlayername() + "\t" + score.getScore());
		}
		
		System.out.println("\n---- BESTENLISTE ----");
		Collections.sort(list);
		for (Highscore score : list) {
			System.out.println(score.getPlayername() + "\t" + score.getScore());
		}
	}

}
