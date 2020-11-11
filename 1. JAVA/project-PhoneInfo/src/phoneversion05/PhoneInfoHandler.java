package phoneversion05;

import java.util.InputMismatchException;
import java.util.Scanner;

import phoneversion05.exception.BadNumberException;
import phoneversion05.exception.StringEmptyException;

// PhoneInfo 타입의 배열로 친구들의 정보를 저장, 수정, 삭제, 검색, 출력하는 기능
public class PhoneInfoHandler {

	private static PhoneInfoHandler handler = new PhoneInfoHandler(100);

	public static PhoneInfoHandler getInstace() {
		return handler;
	}

	// 1. 배열 선언
	PhoneInfo[] myPhones;
	int numOfPhone;

	Scanner kb;

	// 생성자를 통해서 배열 생성
	private PhoneInfoHandler(int num) {
		// 배열의 생성
		myPhones = new PhoneInfo[num];
		// 요소의 개수 초기화
		numOfPhone = 0;
		// Scanner 초기화
		kb = new Scanner(System.in);
	}

	// 2. 배열에 정보 저장
	// 2-1 배열에 추가
	void addPhoneInfo(PhoneInfo info) {
		// 배열에 numOfPhone 숫자 -> index로 참조값을 저장
		myPhones[numOfPhone] = info;
		// 입력된 정보의 개수를 +1 증가시킨다
		numOfPhone++;
	}

	// 2-2 사용자로부터 받은 데이터로 인스턴스 생성
	void createInfo() {

//		System.out.println(" 1.일반 2.대학 3.회사 4.동호회");
//		System.out.println(" 1.대학 2.회사 3.동호회");
//		System.out.println("입력하고자 하는 번호를 입력하세요");
//		int select = kb.nextInt();
//		kb.nextLine();

//		사용자 선택 번호
		int select = 0;

		while (true) {
			System.out.println(" 1.대학 2.회사 3.동호회");
			System.out.println("입력하고자 하는 번호를 입력하세요");

			try {
				select = kb.nextInt();

				// 정상범위 1~3
				if (!(select >= MenuInterface.UNIV && select <= MenuInterface.CAFE)) {
					BadNumberException e = new BadNumberException("메뉴 범위를 벗어나는 번호입니다");

					// 강제적인 예외 발생
					throw e;
				}

			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.\n숫자로 입력하세요.");
//				handler.kb.nextLine();
				continue;
			} catch (BadNumberException e) {
				System.out.println("메뉴 범위를 벗어난 숫자 입력입니다.\n다시 확인 후 입력하세요.");
				continue;
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 입력입니다.\n숫자로 입력하세요.");
				continue;
			} finally {
				handler.kb.nextLine();
			}

			break;

		}

//		if (!(select > 0 && select < 5)) {
//			System.out.println("정상적인 메뉴 선택이 아닙니다.\n 메뉴를 다시 선택하세요.");
//			return;
//		}

		PhoneInfo info = null;
		
		String name = null, phoneNumber=null, address=null, email=null;

		while (true) {

			// 2-2-1 기본 정보 수집: 이름, 번호, 주소, 이메일
			System.out.println("이름을 입력하세요");
			name = kb.nextLine();

			System.out.println("번호를 입력하세요");
			phoneNumber = kb.nextLine();

			System.out.println("주소를 입력하세요");
			address = kb.nextLine();

			System.out.println("이메일을 입력하세요");
			email = kb.nextLine();
			
			try {
				if (name.trim().isEmpty() || phoneNumber.trim().isEmpty() || address.trim().isEmpty()
						|| email.trim().isEmpty()) {
					StringEmptyException e = new StringEmptyException();
					throw e;
				}
			} catch (StringEmptyException e) {
				System.out.println("기본정보는 공백없이 입력하세요.");
				continue;
			}
			
			break;
			
		}
			switch (select) {
			// case 1:
			// // 2-2-2 기본 클래스로 인스턴스 생성
			// info = new PhoneInfo(name, phoneNumber, address, email);
			// break;
			case MenuInterface.UNIV:
				// 2-2-3 대학 클래스로 인스턴스 생성
				System.out.println("전공(학과)를 입력하세요");
				String major = kb.nextLine();
				System.out.println("학년 정보를 입력하세요");
				String grade = kb.nextLine();
				// PhoneUnivInfo 인스턴스 생성
				info = new PhoneUnivInfo(name, phoneNumber, address, email, major, grade);
				break;
			case MenuInterface.COMPANY:
				// 2-2-4 회사 클래스로 인스턴스 생성
				System.out.println("회사의 이름를 입력하세요");
				String company = kb.nextLine();
				System.out.println("부서의 이름을 입력하세요");
				String dept = kb.nextLine();
				System.out.println("직무 정보를 입력하세요");
				String job = kb.nextLine();
				// PhoneCompaanyInfo 인스턴스 생성
				info = new PhoneCompanyInfo(name, phoneNumber, address, email, company, dept, job);
				break;
			case MenuInterface.CAFE:
				// 2-2-5 동호회 클래스로 인스턴스 생성
				System.out.println("동호회의 이름을 입력하세요");
				String cafeName = kb.nextLine();
				System.out.println("닉네임을 입력하세요");
				String nickName = kb.nextLine();
				// PhoneCafeInfo 인스턴스 생성
				info = new PhoneCafeInfo(name, phoneNumber, address, email, cafeName, nickName);
				break;
			}

		
		// 2-3 생성된 인스턴스를 배열에 저장
		addPhoneInfo(info);
	}

	// 3. 배열의 데이터 출력
	void showAllData() {

		// for each 반복문 : 현재 프로그램에서는 사용 불가
		// for 반복문 : 반복의 횟수 지정이 가능 numOfPhone
		System.out.println("전체 정보를 출력합니다");
		for (int i = 0; i < numOfPhone; i++) {
			myPhones[i].ShowData();
			System.out.println("------------------");
		}

	}

	// 배열의 index 검색: 인스턴스의 name 기준
	int searchIndex(String name) {
		// 정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용한다.
		int searchIndex = -1;
		// 배열의 반복으로 name 값을 비교해서 index 값을 찾는다.
		for (int i = 0; i < numOfPhone; i++) {
			if (myPhones[i].name.equals(name)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}

	// 4. 배열의 정보 검색: 이름 기준
	void showInfo() {
		System.out.println("검색하실 이름을 입력하세요");
		String name = kb.nextLine();
		int index = searchIndex(name);
		if (index < 0) {
			System.out.println("검색한 이름의 정보가 없습니다");
		} else {
			System.out.println("---------------");
			myPhones[index].showBasicInfo();
			System.out.println("---------------");
		}

	}

	// 5. 배열의 정보 삭제: 이름 기준
	void delteInfo() {
		System.out.println("삭제하실 이름을 입력하세요");
		String name = kb.nextLine();
		int index = searchIndex(name);
		if (index < 0) {
			System.out.println("삭제하려는 이름의 정보가 없습니다");
			return;
		} else {
			// 삭제 위치에서 왼쪽으로 시프트
			for (int i = index; i < numOfPhone - 1; i++) {
				myPhones[i] = myPhones[i + 1];
			}
			// 삭제가 되었으므로 요소의 개수도 -1
			numOfPhone--;
		}
	}

	// 6. 배열의 정보를 수정 : 이름 기준
	void editInfo () {
		System.out.println("수정하실 이름을 입력하세요");
		String name = kb.nextLine();
		int index = searchIndex(name);
		if (index < 0) {
			System.out.println("수정하려는 이름의 정보가 없습니다");
		} else {

			String editname = myPhones[index].name;

			System.out.println("수정 데이터 입력을 시작합니다");
			System.out.println("이름은 " + editname + "입니다");
			
			
			// 수정 시 기본정보 공백 예외처리
			while(true) {
				System.out.println("전화번호를 입력하세요");
				String phoneNumber = kb.nextLine();
				System.out.println("주소를  입력하세요");
				String address = kb.nextLine();
				System.out.println("이메일을 입력하세요");
				String email = kb.nextLine();
				
				try {
					if(phoneNumber.trim().isEmpty() || address.trim().isEmpty()
							|| email.trim().isEmpty()) {
						StringEmptyException e = new StringEmptyException();
						throw e;
					}
				} catch (StringEmptyException e) {
					System.out.println("수정 시 기본정보는 공백없이 입력하세요");
					continue;
				}
				
				break;
				
			}
		
			String phoneNumber=null, address=null, email=null;
			PhoneInfo info = null;

			// 저장된 인스턴스 : 기본, 대학, 회사, 동호회
			if (myPhones[index] instanceof PhoneUnivInfo) {
				System.out.println("전공을 입력하세요");
				String major = kb.nextLine();
				System.out.println("학년을 입력하세요");
				String grade = kb.nextLine();

				info = new PhoneUnivInfo(editname, phoneNumber, address, email, major, grade);
			} else if (myPhones[index] instanceof PhoneCompanyInfo) {
				System.out.println("회사 이름을 입력하세요");
				String company = kb.nextLine();
				System.out.println("부서 이름을 입력하세요");
				String dept = kb.nextLine();
				System.out.println("직급을 입력하세요");
				String job = kb.nextLine();

				info = new PhoneCompanyInfo(editname, phoneNumber, address, email, company, dept, job);

			} else if (myPhones[index] instanceof PhoneCafeInfo) {
				System.out.println("동호회 이름을 입력하세요");
				String cafeName = kb.nextLine();
				System.out.println("닉네임을 입력하세요");
				String nickName = kb.nextLine();

				info = new PhoneCafeInfo(editname, phoneNumber, address, email, cafeName, nickName);

			}
//			else if (myPhones[index] instanceof PhoneInfo) {
//				info = new PhoneInfo(editname, phoneNumber, address, email);
//			}

			// 배열에 새로운 인스턴스를 저장
			myPhones[index] = info;

		}

	}

}
