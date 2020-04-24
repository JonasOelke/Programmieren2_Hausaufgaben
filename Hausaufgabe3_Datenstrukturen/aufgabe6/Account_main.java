package aufgabe6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account_main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		HashSet<Account> accounts = new HashSet<Account>();
		

		final int MIN = 100000000;
		final int MAX = 999999999;
		
		String[] names = {"Claudia","Bob", "Karl", "Alice", "Gustav"};
		for (int i = 0; i < names.length; i++) {
			accounts.add(new Account(names[i], 0 + Integer.toString(ThreadLocalRandom.current().nextInt(MIN,MAX+1))));
		}
		
		System.out.println("Herzlich Willkommen! <3 \nBitte lege einen Account an.\n" 
		+ "Dazu einfach den Benutzernamen gefolgt von einem Leerzeichen und der Telfonnummer eingeben");
		
		String[] newAccount = input.nextLine().split("\\s",2);	
		accounts.add(new Account(newAccount[0], newAccount[1]));
		
		/*
		 * TODO Man könnte hier noch prüfen, ob es entweder die Handynummer oder den Benutzernamen schon gibt,
		 * da die Erstellung eines Accounts mit dem selben Username aber mit einer anderen Handynummer immer noch möglich ist. 
		 */
		
		for (Account account : accounts) {
			System.out.println(account.getUsername() + "\t " + account.getPhone());
		}
;
	}

}
