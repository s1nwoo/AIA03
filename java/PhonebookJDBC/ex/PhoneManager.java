package ex;

import java.util.InputMismatchException;
import java.util.List;

import manager.Dept;
import phoneversion05.exception.BadNumberException;
import phoneversion06.MenuInterface;

public class PhoneManager {

	PhoneInfor pi;
	PhoneDao dao = new PhoneDao();
	
	public void insertInfor() {

		pi = new PhoneInfor();
		
		System.out.println("전화번호부 등록을 시작합니다");
		System.out.println();
		System.out.println("이름을 입력하세요");
		PhoneMain.sc.nextLine();
		String name = PhoneMain.sc.nextLine();
		
		System.out.println("번호를 입력하세요");
		String phonenumber = PhoneMain.sc.nextLine();
		
		System.out.println("이메일을 입력하세요");
		String email = PhoneMain.sc.nextLine();
		
		System.out.println("주소를 입력하세요");
		String address = PhoneMain.sc.nextLine();
		
		System.out.println("분류 : 1.대학 || 2.회사 || 3. 동호회");
		
		int select = PhoneMain.sc.nextInt();
		
		switch(select) {
		case 1:
			pi.setCategory("UNIV");
			
			System.out.println("전공을 입력하세요");
			PhoneMain.sc.nextLine();
			String major = PhoneMain.sc.nextLine();

			System.out.println("학년을 입력하세요");
			String garde = PhoneMain.sc.nextLine();
			
			break;
			
		case 2:
			pi.setCategory("COM");
			
			System.out.println("회사명을 입력하세요");
			PhoneMain.sc.nextLine();
			String com = PhoneMain.sc.nextLine();
			
			System.out.println("부서명을 입력하세요");
			String dept = PhoneMain.sc.nextLine();
			
			System.out.println("직업을 입력하세요");
			String job = PhoneMain.sc.nextLine();
			
			break;
		case 3:
			pi.setCategory("CAFE");
			
			System.out.println("동호회명을 입력하세요");
			PhoneMain.sc.nextLine();
			String gamename = PhoneMain.sc.nextLine();
			
			System.out.println("닉네임명을 입력하세요");
			String nickname = PhoneMain.sc.nextLine();
			
			break;
		}
		
	
		int resultCnt = dao.insertInfor(pi);
		
		if (resultCnt > 0) {
			System.out.println("정상적으로 입력 되었습니다.");
			System.out.println(resultCnt + "행이 입력되었습니다.");
		} else {
			System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
		}
		
	}

	public void listInfor() {

		List<PhoneInfor> listInfor = dao.listInfor();

		if (listInfor != null && !listInfor.isEmpty()) {

			for (int i = 0; i < listInfor.size(); i++) {
				System.out.printf("%5s", listInfor.get(i).getName() + "\t");
				System.out.printf("%12s", listInfor.get(i).getPhonenumber() + "\t");
				System.out.printf("%12s", listInfor.get(i).getAddress() + "\n");
			}
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}

	}
	
	
}
