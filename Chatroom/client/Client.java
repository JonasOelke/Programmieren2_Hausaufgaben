package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.Message;

public class Client {
	
	private final Socket socket;
	private final InputStream inStream;
	private final Scanner input;
	private final OutputStream outStream;
	private final PrintWriter output;
	private final String username;
	private boolean isRunning = true;
	
	/**
	 * @param host The host you are trying to connect to
	 * @param port The port the host to listen for connections
	 * @param username The username you want to see right next to the messages you sent
	 */
	Client(String host, int port, String username) throws UnknownHostException, IOException {
		System.out.println("Trying to connect ... hold on!");
		this.username = username;
		this.socket = new Socket(host, port);
		this.inStream = socket.getInputStream();
		outStream = socket.getOutputStream();
		output = new PrintWriter(outStream);
		input = new Scanner(inStream);
		
		/*
		 * Prints the "Successfully connected" message from server
		 */
		System.out.println(input.nextLine());
		
		
		
		readerThread();
		writeMessage(output);
			
	}
	
	/**
	 * continuously listening for incoming messages
	 */
	private void readerThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					/*
					 * Checks if everythings before the first : equals to the username.
					 * If this is the cause, the message won't be printed.  
					 */
					String msg = input.nextLine();
					Pattern pattern = Pattern.compile("\\w*:");
					Matcher matcher = pattern.matcher(msg);
					if (!(matcher.find() && matcher.group().equals(username + ":"))) {
						System.out.println(msg);
					} 
				}
			}
		}).start();
	}

	/**
	 * continuously listening for messages entered by the user
	 * and sending them to the server
	 */
	private void writeMessage(PrintWriter printWriter) {
		Scanner keyboard = new Scanner(System.in);
		while(isRunning) {
			String text = keyboard.nextLine();
			if (text.equalsIgnoreCase("exit")) {
				System.exit(0);
			}	else {
				printWriter.println(username + ": " + text);
				printWriter.flush();
			}
		}
		keyboard.close();
	}
	
	
}
