package ex;

import java.util.InputMismatchException;

import phoneversion05.exception.BadNumberException;
import phoneversion06.MenuInterface;

public class PhoneManager {

	PhoneDao dao = new PhoneDao();
	
	public void insertImfor() {

		int select = 0;

		while (true) {
			System.out.println("친구 정보 입력을 시작합니다");
			System.out.println("입력하고자 하는 분류를 선택하세요");
			System.out.println("1. 대학 || 2. 회사 || 3. 게임");

			try {
				select = PhoneMain.sc.nextInt();

				// 정상범위 1~3
				if (!(select >= MenuInterface.UNIV && select <= MenuInterface.GAME)) {
					BadNumberException e = new BadNumberException("메뉴 범위를 벗어나는 번호입니다");

					// 강제적인 예외 발생
					throw e;
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.\n숫자로 입력하세요.");
				continue;
			} catch (BadNumberException e) {
				System.out.println("메뉴 범위를 벗어난 숫자 입력입니다.\n다시 확인 후 입력하세요.");
				continue;
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 입력입니다.\n숫자로 입력하세요.");
				continue;
			} finally {
				PhoneMain.sc.nextLine();
			}

			break;

		}

		while (true) {

			System.out.println("ID번호를 입력하세요");
			int idx = PhoneMain.sc.nextInt();

			System.out.println("이름을 입력하세요");
			String fr_name = PhoneMain.sc.nextLine();

			System.out.println("번호를 입력하세요");
			String fr_phonenum = PhoneMain.sc.nextLine();

			System.out.println("주소를 입력하세요");
			String fr_address = PhoneMain.sc.nextLine();

			System.out.println("이메일을 입력하세요");
			String fr_email = PhoneMain.sc.nextLine();

			break;

		}

		switch(select) {
		case 1:
			System.out.println("전공(학과)를 입력하세요");
			String fr_u_major = PhoneMain.sc.nextLine();
			System.out.println("학년 정보를 입력하세요");
			String fr_u_grade = PhoneMain.sc.nextLine();
			
			PhoneUniv univ = new PhoneUniv(fr_u_major, fr_u_grade); 
			
			int resultCnt = 
			
		}
		
	}

}
