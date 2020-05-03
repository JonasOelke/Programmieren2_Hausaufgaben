package ufogame;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		//TODO: Das kann man natürlich auch noch grafisch bauen, aber darum geht's ja erstmal nicht.
		
		System.out.println(	"Willkommen zu UFO WORLD 2020 \n"
				+ 			"------------------------------- \n	"
				+ 			"Bitte gib jetzt deinen Namen (oder ein Pseudonym) an und drücke dann Enter, um das Spiel zu starten:");
		Scanner input = new Scanner(System.in);
		String playerName = input.nextLine();
		//String playerName = "dev";	
		input.close();
		Game game = new Game(playerName);
		game.init();
	}
}
