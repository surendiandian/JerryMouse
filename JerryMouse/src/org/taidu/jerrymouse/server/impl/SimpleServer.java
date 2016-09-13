package org.taidu.jerrymouse.server.impl;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleServer {
	
	
	private int port;
	
	
	
	public SimpleServer(int port) {
		this.port=port;
	}
	
	
	public void start() throws Exception{
		//监听一个端口
		ServerSocket server=new ServerSocket(port);
		System.out.println("jerryMouse启动成功");
		while (true) {
			//创建一个线程池
			ExecutorService pool=Executors.newFixedThreadPool(3);
			
			//等待请求的进入
			Socket serverPerson= server.accept();
			//创建一个线程的执行类
			ServerRun run=new ServerRun(serverPerson);
			
			//表示在线程池中启动线程
			pool.execute(run);
			/*
			
			
			Thread thread=new Thread(run);
			thread.start();*/
		}
	}

}
