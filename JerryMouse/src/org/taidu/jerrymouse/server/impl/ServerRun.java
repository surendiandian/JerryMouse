package org.taidu.jerrymouse.server.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.taidu.jerrymouse.util.StrPath;

/*
 * sure
 */
public class ServerRun implements Runnable {

	
	private Socket socket;
	
	
	
	
	
	
	
	public ServerRun(Socket socket) {
		
		this.socket = socket;
	}



	@Override
	public void run() {
		try {
			//获得读取器
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//获得打印器
			PrintWriter pw=new PrintWriter(socket.getOutputStream());
			
			StringBuilder strBuilder=new StringBuilder();
			String contentTmp="";
			//通过读取器，保存客户端请求传输的信息
			while ((contentTmp=reader.readLine())!=null) {
				
				strBuilder.append(contentTmp+"\n");
				if("".equals(contentTmp)){
					break;
				}
			}
			String content=strBuilder.toString();//强求的所有内容拼接
			
			int begin=content.indexOf(" ");
			String path=content.substring(begin).trim();
			int end=path.indexOf(" ");
			path=path.substring(0,end);//取到请求路径的地址
			System.out.println("path:"+path);
			
			//获得真实需要读取的文件
			FileInputStream file=new FileInputStream(new File(StrPath.PROJECTPATH+path));
			
			InputStreamReader readerStream=new InputStreamReader(file);
			
			
			BufferedReader buffReader=new BufferedReader(readerStream);
			
			
		
			pw.println("HTTP/1.1 200");
			pw.println("Server: Apache-Coyote/1.1");
			pw.println("Set-Cookie: JSESSIONID=878A38EA78B38B4420E72F85E97582CB; Path=/web/; HttpOnly");
			pw.println("Content-Type: text/html;charset=ISO-8859-1");
			pw.println("Content-Length: 620");
			pw.println("Date: Sun, 11 Sep 2016 00:38:40 GMT");
			pw.println("");
			
			
			
			String tmp="";
			String htmlContent="";
			//读取真实文件中的内容
			while ((tmp=buffReader.readLine())!=null) {
				htmlContent+=tmp+"\n";
				//返回给客户端
				pw.println(tmp);
			}
			
			pw.flush();
			pw.close();
			Thread.sleep(20000);
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
