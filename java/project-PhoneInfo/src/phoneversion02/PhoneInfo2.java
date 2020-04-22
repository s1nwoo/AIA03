package phoneversion02;

import java.util.Scanner;

import phoneversion01.PhoneInfo;
/*
	Project : ver 0.20
	"프로그램 사용자로부터 데이터 입력"
	프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이 핵심.
	단, 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
	프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.
	키보드로부터 데이터 입력 → 입력 받은 데이터로 인스턴스 생성 → 생성된 인스턴스의 메소드 호출
 */

public class PhoneInfo2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		fristloop: while (true) {

			System.out.println("이름을 입력하시오.");
			String name = sc.nextLine();

			System.out.println(name + "님의 번호를 입력하시오");
			String num = sc.nextLine();

			System.out.println(name + "님의 생년월일을 입력하세요. 넘어가려면 엔터를 누르세요");
			String day = sc.nextLine();

			if (day.equals("")) {
				PhoneInfo data1 = new PhoneInfo(name, num);
				data1.showData();
			} else {
				PhoneInfo data1 = new PhoneInfo(name, num, day);
				data1.showData();
			}

			while (true) {

				System.out.println("추가하기 : 1, 그만하기 : 2");

				String out = sc.nextLine();

				if (out.equals("2")) {
					break fristloop;
				} else if (out.equals("1")) {
					continue fristloop;
				} else {
					System.out.println("★오류입니다★  \n1과 2만 입력하세요");
					continue;
				}
			}
		} // fristloop: while (true)
		System.out.println("전화번호부 등록을 종료합니다.");
	}
}
