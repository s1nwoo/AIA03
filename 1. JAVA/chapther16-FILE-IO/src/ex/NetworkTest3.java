package ex;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkTest3 {

	public static void main(String[] args) {

		URL url = null;
		String address = "https://www.google.com/search?q=java&rlz=1C1CHBD_koKR895KR895&oq=java&aqs=chrome..69i57j0l4j69i60l2j69i61.3287j0j4&sourceid=chrome&ie=UTF-8";
		
		BufferedReader input = null;
		
		String line = "";
		
		try {
			
			url = new URL(address);
			
			input = new BufferedReader(new InputStreamReader(url)); 
		while(true) {
			line = input.readLine()	;
			if(line==null) {
				break;
			}
			System.out.println(line);
		}
		
		input.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
