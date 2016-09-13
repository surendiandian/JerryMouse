package org.taidu.jerrymouse.thread;

public class RunnableDemo implements Runnable {

	
	private int count;
	
	@Override
	public synchronized  void run() {
		while(count<100){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(count);
			count++;
		}
	}

}
