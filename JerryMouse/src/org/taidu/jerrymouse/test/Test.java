package org.taidu.jerrymouse.test;

import org.taidu.jerrymouse.server.impl.SimpleServer;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SimpleServer server=new SimpleServer(8080);
		server.start();
	}

}
