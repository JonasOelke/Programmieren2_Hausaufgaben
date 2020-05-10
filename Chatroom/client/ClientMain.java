package client;

import java.io.IOException;
import java.util.Scanner;

public class ClientMain {
	
	public static void main(String[] args) {
		/* 
		 * Define where the client should listen for messages:
		 */
		final String host = "127.0.0.1";
		final int port = 3345;
		
		System.out.println("Please specify a username you want to use - no spaces allow, sorry :P");
		
		Scanner keyboard = new Scanner(System.in);
		String username = keyboard.next();
		
		try {
			Client client = new Client(host, port, username);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ooops... it looks like we're having trouble to connect to the server. "
					+ "Please restart once you're sure the server must be running.");
		}
		System.out.println("reached it till here");
	}
	
}
