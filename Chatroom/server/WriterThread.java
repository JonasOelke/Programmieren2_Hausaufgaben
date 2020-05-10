package server;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread{
	
	private BlockingQueue<String> messages;
	
	private ArrayList<PrintWriter> connections = new ArrayList<PrintWriter>();
	private boolean isRunning = true;
	
	public WriterThread(BlockingQueue<String> messages) {
		super();
		this.messages = messages;
		System.out.println("WriterThread sucessfully initialsied");
		
		messages.add("Test 1");
		messages.add("Test 2");
		System.out.println("Test Messages are created.");
		
	}

	@Override
	public void run() {
		while(isRunning) {
			try {
				if (messages.size() > 0 && connections.size() > 0) {
					String message = messages.poll();
					for (PrintWriter connection : connections) {
						System.out.println("\n A message will be send to all clients.");
						connection.println(message);
						connection.flush();
					}
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addPrintWriter(PrintWriter writer) {
		connections.add(writer);
	}
	
}
