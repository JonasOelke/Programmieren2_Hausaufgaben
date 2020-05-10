package client;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread {

	private Scanner scanner;
	private boolean isRunning = true;

	public ReaderThread(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	@Override
	public void run() {
		
	}
	
	public void quit() {
		isRunning = false;
	}
}
