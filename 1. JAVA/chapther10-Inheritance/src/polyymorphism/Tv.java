package polyymorphism;

public class Tv {

	boolean power;
	int channel;

	void power() {
		power = !power;
	}

	void channelUp() {
		channel++;
	}

	void channelDown() {
		channel--;
	}
	
	void display() {
		System.out.println("Tv 재생합니다.");
	}

}
