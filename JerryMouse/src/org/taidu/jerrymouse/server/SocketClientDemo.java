package org.taidu.jerrymouse.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientDemo {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket client = new Socket("localhost", 8080);

		PrintWriter pw = new PrintWriter(client.getOutputStream());

		pw.println("GET /web/index.jsp HTTP/1.1");
		pw.println("Host: localhost:8080");
		pw.println("User-Agent: Mozilla/5.0 (Windows NT 6.1; rv:48.0) Gecko/20100101 Firefox/48.0");
		pw.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		pw.println("Accept-Language: zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		pw.println("Accept-Encoding: gzip, deflate");
		pw.println("Connection: keep-alive");
		pw.println("Upgrade-Insecure-Requests: 1");

		pw.println();
		pw.flush();

		InputStreamReader reader = new InputStreamReader(
				client.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(reader);
		String contentTmp = "";
		String respContent = "";
		while ((contentTmp = bufferedReader.readLine()) != null) {
			respContent += contentTmp;
			if("</html>".equals(contentTmp)){
				break;
			}
			System.out.println(contentTmp);
			
		}

	}
}
