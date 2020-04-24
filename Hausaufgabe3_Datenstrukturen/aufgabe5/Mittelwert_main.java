package aufgabe5;

import java.util.LinkedList;
import java.util.Scanner;

public class Mittelwert_main {

	public static void main(String[] args) {
		
		/* 
		 * Wenn man das Programm mit zwei Variablen double result und int count initialisert, die Eingaben direkt dem result hinzuaddiert
		 * count inkrementiert und dann nur noch durch den count teilt, ist es denke ich das performanteste, weil man komplett auf
		 * LinkedLists, Arrays und ArrayLists verzichten kann - aber ich glaube, dass das hier nicht gefordert ist. 
		 */
		
		System.out.println("Herzlich Willkommen! <3 \nGib solange Zahlen ein, bis dir die Zahlen ausgehen oder du keine Lust mehr hast. Viel Spaß!");
		
		Scanner input = new Scanner(System.in);
		
		//LinkedList over ArrayList: Es finden keine komplizierten Vorgänge statt, sonder nur der Reihe nach einfügen und auslesen
		//LinkedList hat beim hinzufügen jedoch einen Worst-Case von O(1) während ArrayList einen Worst-Case von O(n) hat. 
		LinkedList<Double> numbers = new LinkedList<Double>();
		
		boolean quit = false;
		
		
		while (!quit) {
			String next = input.next();
			if (next.equals("quit")) break;
			else {
				try {
					numbers.add(Double.parseDouble(next));
				} catch (NumberFormatException e) {
					System.out.println("Hopla, das war wohl keine Zahl. Versuchs nochmal!");
				}
				
			}
		}
		
		Double result = 0.0;
		for (Double number : numbers) {
			result += number;
		}
		
		result = result / numbers.size();
		
		System.out.println(result);
		
		input.close();

	}

}
