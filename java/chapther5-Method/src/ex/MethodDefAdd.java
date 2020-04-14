package ex;

public class MethodDefAdd {

	public static void main(String[] args) {

		System.out.println("프로그램의 시작");
		hiEveryone(10, 110.5);
		hiEveryone(20, 180.2);
		hiEveryone(17, 178.9);
		hiEveryone(25, 160);
		hiEveryone(15, 165.7);
		hiEveryone(19, 170);
		System.out.println("프로그램의 끝");
	}

	public static void hiEveryone(int age, double height) {
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 " + age + "세입니다.");
		System.out.println("저의 키는 " +height+ "cm 입니다.");
	}
}