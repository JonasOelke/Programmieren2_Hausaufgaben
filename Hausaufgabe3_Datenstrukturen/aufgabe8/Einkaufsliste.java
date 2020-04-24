package aufgabe8;

import java.util.HashMap;
import java.util.Random;

public class Einkaufsliste {

	public static void main(String[] args) {
		/*
		 * Die einzukaufende Menge wird dem Artikel zugeordnen
		 * Ergo ist der Artikel KEY und die Menge VALUE
		 */
		Random rand = new Random();
		HashMap<String,Integer> shoppingList = new HashMap<>();
		
		String[] articles = {"Klopapier", "Nudeln", "Tomatensosse", "Chips", "Cola", "Alkohol", "Bier", "mehr Bier", "noch mehr Bier"};
		
		for (int i = 0; i < articles.length; i++) {
			shoppingList.put(articles[i], rand.nextInt(15));
		}
		System.out.println("DIE MAGISCHE STUDENTISCHE CORONA SHOPPING LIST FÜR JEDE WG! \n----------------------------------------------");
		for (String article : shoppingList.keySet()) {
			System.out.format("%-15s%-15s\n", article, shoppingList.get(article));
		}

	}

}
