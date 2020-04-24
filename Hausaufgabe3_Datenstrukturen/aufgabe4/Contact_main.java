package aufgabe4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import aufgabe2.Highscore;

public class Contact_main {

	public static void main(String[] args) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		String[] names = {"Claudia","Bob", "Karl", "Alice", "Gustav"};
		
		final int MIN = 100000000;
		final int MAX = 999999999;
		
		
		for (int i = 0; i < names.length; i++) {
			Contact score = new Contact(names[i],0 + Integer.toString(ThreadLocalRandom.current().nextInt(MIN,MAX+1)));
			contacts.add(score);
		}
		
		System.out.println("---- CONTACTS ----");
		for (Contact contact: contacts) {
			System.out.println(contact.getName() + "\t" + contact.getPhone());
		}
		
		Collections.sort(contacts);
		
		System.out.println("\n---- CONTACTS (sorted alphabetically) ----");
		for (Contact contact: contacts) {
			System.out.println(contact.getName() + "\t" + contact.getPhone());
		}


	}

}
