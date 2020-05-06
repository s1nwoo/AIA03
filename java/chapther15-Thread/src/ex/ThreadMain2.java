package ex;

public class ThreadMain2 {

	public static void main(String[] args) {

		
		// Runnable을 구현하는 인스턴스 생성
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		// 쓰레드 인스턴스 생성
		Thread tr1 = new Thread(at1);
		Thread tr2 = new Thread(at2);
		
		// 실행의 흐름 생성
		tr1.start();
		tr2.start();
		
		try {
			tr1.join();
			tr2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100까지의 합: "+at1.getNum()+at2.getNum());
		
		
		
		
	}

}
