package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server extends Thread{
	
	private int connectionCount = 0;
	private ArrayList<ConnectionThread> connections = new ArrayList<ConnectionThread>();

	private final int MAX_CONNECTIONS;
	private final int PORT;
	private ServerSocket serverSocket;

	Server(int MAX_CONNECTIONS, int PORT) throws IOException{
		this.MAX_CONNECTIONS = MAX_CONNECTIONS;
		this.PORT = PORT;
		
		System.out.println("Allocated Constants");
		serverSocket = new ServerSocket(this.PORT, this.MAX_CONNECTIONS);
		System.out.println("ServerSocket created");
	}
	
	@Override
	public void run() {
		try {

			/*
			 * Accepts Connections until the MAX_CONNECTIONS is reached.
			 * Creates a Connections-Thread
			 */
			do {
				System.out.println("Waiting for Clients...");
				Socket socket = serverSocket.accept();
				//ConnectionThread connection = new ConnectionThread(serverSocket, socket);
				//connection.start();
				//connections.add(connection);
				System.out.println("Connection established!");
			} while (connectionCount < MAX_CONNECTIONS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean Start() {
		try {

			/*
			 * Accepts Connections until the MAX_CONNECTIONS is reached.
			 * Creates a Connections-Thread
			 */
			do {
				System.out.println("Waiting for Clients...");
				Socket socket = serverSocket.accept();
				//ConnectionThread connection = new ConnectionThread(serverSocket, socket);
				//connection.start();
				//connections.add(connection);
				//System.out.println("Connection established!");
			} while (connectionCount < MAX_CONNECTIONS);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean Stop() {
		try {
			serverSocket.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
