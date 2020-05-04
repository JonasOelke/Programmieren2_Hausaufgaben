package view;

import java.util.LinkedList;

public class TicksThread extends Thread{

	LinkedList<ITickableListener> ticks;
	int delay;
	
	@Override 
	public void run() {
		notifyTicks();
		
	}
	
	public void notifyTicks() {
		try {
			for (ITickableListener tickable : ticks) {
				tickable.tick(delay);
			}
			this.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDelay(int delay) {
		this.delay = delay;
		
	}

	public void setTicks(LinkedList<ITickableListener> ticks) {
		this.ticks = ticks;
		
	}
}
