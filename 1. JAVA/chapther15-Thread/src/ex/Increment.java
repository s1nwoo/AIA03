package ex;

public class Increment {

	int num = 0;
	
	synchronized void increment() {
		num++;
	}
	
	int getnum() {
		return num;
	}
	
}
