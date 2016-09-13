package org.taidu.jerrymouse.thread;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ThreadDemo demo1=new ThreadDemo();
		demo1.start();
		demo1.start();*/
		
		
		RunnableDemo demo2=new RunnableDemo();
		Thread t=new Thread(demo2);
		Thread t1=new Thread(demo2);
		t.start();
		t1.start();
		
	}

}
