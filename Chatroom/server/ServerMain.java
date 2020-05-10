package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain {
	
	private final int MAX_CONNECTIONS;
	private final int PORT;
	private ServerSocket server;
	private ArrayList<PrintWriter> connections = new ArrayList<PrintWriter>();
	public BlockingQueue<String> messages = new LinkedBlockingQueue<String>();
	WriterThread writerThread;

	ServerMain(int PORT, int MAX_CONNECTIONS) throws IOException{
		this.MAX_CONNECTIONS = MAX_CONNECTIONS;
		this.PORT = PORT;
		System.out.println("Allocated Constants");
		
		server = new ServerSocket(this.PORT, this.MAX_CONNECTIONS);
		System.out.println("ServerSocket created");
	}
	
	public void Start() {
		try {
			writerThread = new WriterThread(messages);
			writerThread.start();
			
			/*
			 * Accepts Connections until the MAX_CONNECTIONS is reached.
			 * Creates a Connections-Thread
			 */
			do {
				System.out.println("Waiting for Clients...");
				Socket socket = server.accept();
				
				System.out.println("Connection accepted!");
				ConnectionThread connection = new ConnectionThread(server, socket, writerThread, messages);
				connection.start();
				
				System.out.println("Connection established!");
			} while (connections.size() < MAX_CONNECTIONS);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		
		try {
			ServerMain server;
			server = new ServerMain(3345,10);
			server.Start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
