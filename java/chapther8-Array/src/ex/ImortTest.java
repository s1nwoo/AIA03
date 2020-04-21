package ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImortTest {

	public static void main(String[] args) {

		// java.util.Date : 날짜와 시간 정보를 하나로 표현
		Date today = new Date();
		
		System.out.println(today); //today.toString()
		
		SimpleDateFormat dateFomat = new SimpleDateFormat("yyyy.MM.dd. a hh:mm");
		
		System.out.println(dateFomat.format(today));
	}

}
