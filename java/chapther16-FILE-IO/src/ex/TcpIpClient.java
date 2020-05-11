package ex;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("192.168.0.107", 7777);
			
			// 소켓의 inputstream 객체를 얻어온다
			InputStream in = socket.getInputStream();
			DataInputStream din = new DataInputStream(in);
		
			System.out.println("서버 : "+din.readUTF());
			
			System.out.println("연결을 종료합니다");
			
			din.close();
			socket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
	