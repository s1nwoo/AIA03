package ex;

public class CalAddThread extends Thread {

	Calcurator cal;
	
	public CalAddThread(Calcurator c) {
		cal = c;
		
	}

	@Override
	public void run() {
		System.out.println(cal.add(1, 2));
		System.out.println(cal.add(2, 4));
		
		
	}
	
	
	
}
