package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ConnectionThread extends Thread{
	private boolean isrunning = false;
	BlockingQueue<String> messages;
	private final ServerSocket server;
	private final Socket socket;
	private final WriterThread writerThread;
	private final OutputStream outStream;
	private final PrintWriter output;
	private final InputStream inStream;
	private final Scanner input; 
	
	@Override
	public void run() {
		isrunning = true;
		while (isrunning) {
			if (input.hasNext()) {
				String message = input.nextLine();
				System.out.println(message);
				messages.add(message);
			}
		} 
		input.close();
		
	}
	
	public void initConnection() {
		System.out.println("starting init.");
		output.println("Successfully connected!");
		output.flush();
		System.out.println("Message sent to client");
		writerThread.addPrintWriter(output);
	}
	
	public ConnectionThread(ServerSocket server, Socket socket, WriterThread writerThread, BlockingQueue<String> messages) throws IOException {
		this.writerThread = writerThread;
		this.server = server;
		this.socket = socket;
		this.messages = messages;
		outStream = socket.getOutputStream();
		output = new PrintWriter(outStream);
		inStream = socket.getInputStream();
		input = new Scanner (inStream);
		
		initConnection();
	}

}
