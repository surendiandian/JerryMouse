package org.taidu.jerrymouse.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket=new ServerSocket(8080);
		
		Socket socket= serverSocket.accept();
		
		
		Reader reader=new InputStreamReader(socket.getInputStream());
		BufferedReader bufferedReader=new BufferedReader(reader);
		StringBuilder strBuilder=new StringBuilder();
		String contentTmp="";
		while ((contentTmp=bufferedReader.readLine())!=null) {
			
			strBuilder.append(contentTmp+"\n");
			if("".equals(contentTmp)){
				break;
			}
		}
		
		
		String content=strBuilder.toString();
		
		int begin=content.indexOf(" ");
		String path=content.substring(begin).trim();
		int end=path.indexOf(" ");
		path=path.substring(0,end);
		System.out.println("path:"+path);
		
		
		System.out.println(strBuilder);
		
		PrintWriter pw=new PrintWriter(socket.getOutputStream());
		pw.println("HTTP/1.1 200");
		pw.println("Server: Apache-Coyote/1.1");
		pw.println("Set-Cookie: JSESSIONID=878A38EA78B38B4420E72F85E97582CB; Path=/web/; HttpOnly");
		pw.println("Content-Type: text/html;charset=ISO-8859-1");
		pw.println("Content-Length: 620");
		pw.println("Date: Sun, 11 Sep 2016 00:38:40 GMT");
		pw.println("");
		pw.println("<html><body><a href='http://www.baidu.com'>click me</a></body></html>");
		pw.flush();
		pw.close();
	}
}
