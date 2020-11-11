package ex;

import java.util.List;


public class PhoneManager {

	PhoneDao dao = new PhoneDao();
	
	public void insertInfor() {

		PhoneInfor pi = null;
		int resultUnivCnt=0;
		int resultComCnt=0;
		int resultCafeCnt=0;

		
		
		System.out.println("분류 : 1.대학 || 2.회사 || 3. 동호회");
		int select = PhoneMain.sc.nextInt();
		
		System.out.println("이름을 입력하세요");
		PhoneMain.sc.nextLine();
		String name = PhoneMain.sc.nextLine();
		
		System.out.println("번호를 입력하세요");
		String phonenumber = PhoneMain.sc.nextLine();
		
		System.out.println("주소를 입력하세요");
		String address = PhoneMain.sc.nextLine();
		
		System.out.println("이메일을 입력하세요");
		String email = PhoneMain.sc.nextLine();
		
		
		switch(select) {
		case 1:
			
			System.out.println("전공을 입력하세요");
			String major = PhoneMain.sc.nextLine();

			System.out.println("학년을 입력하세요");
			String grade = PhoneMain.sc.nextLine();
			
			String category = "UNIV";
			String company = null;
			String dept = null;
			String job = null;
			String cafename = null;
			String nickname = null;
			
			pi = new PhoneInfor(name, phonenumber, address, email, category, major, grade, company, dept, job, cafename, nickname);
			
			resultUnivCnt = dao.insertInfor(pi);
			
			if (resultUnivCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultUnivCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
			
			return;
			
		case 2:
			
			category= "COM";
			major = null;
			grade = null;
			cafename = null;
			nickname = null;
			
			System.out.println("회사명을 입력하세요");
			company = PhoneMain.sc.nextLine();
			
			System.out.println("부서명을 입력하세요");
			dept = PhoneMain.sc.nextLine();
			
			System.out.println("직업을 입력하세요");
			job = PhoneMain.sc.nextLine();
			
			
			pi = new PhoneInfor(name, phonenumber, address, email, category, major, grade, company, dept, job, cafename, nickname);
			
			resultComCnt = dao.insertInfor(pi);
			
			if (resultComCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultComCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
			
			return;
			
		case 3:
			
			System.out.println("동호회명을 입력하세요");
			cafename = PhoneMain.sc.nextLine();
			
			System.out.println("닉네임명을 입력하세요");
			nickname = PhoneMain.sc.nextLine();
			
			category = "CAFE";
			major = null;
			grade = null;
			company = null;
			dept = null;
			job = null;
			
			pi = new PhoneInfor(name, phonenumber, address, email, category, major, grade, company, dept, job, cafename, nickname);
			
			resultCafeCnt = dao.insertInfor(pi);
			
			if (resultCafeCnt > 0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCafeCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
			
			return;
		}
		
	}

	
	public void searchInfor() {

		// 사용자 입력정보 변수

		System.out.println("검색하고자 하는 이름 : ");
		PhoneMain.sc.nextLine();
		String searchName = PhoneMain.sc.nextLine();

		List<PhoneInfor> list = dao.searchInfor(searchName);
		System.out.println("★☆★☆"+"["+searchName+"]"+ "이 포함된 이름을 출력합니다★☆★☆");
		System.out.println("=============================================================================================================================");
		System.out.println("인덱스\t카테고리\t이름\t전화번호\t\t주소\t이메일\t\t전공\t학번\t회사\t부서\t직급\t동호회\t닉네임");
		System.out.println("=============================================================================================================================");
		for (PhoneInfor pi : list) {
			System.out.printf("%3s", pi.getPidx()+"\t");
			System.out.printf("%5s", pi.getCategory()+"\t");
			System.out.printf("%5s", pi.getName()+"\t");
			System.out.printf("%5s", pi.getPhonenumber()+"\t");
			System.out.printf("%5s", pi.getAddress()+"\t");
			System.out.printf("%5s", pi.getEmail()+"\t");
			System.out.printf("%5s", pi.getMajor()+"\t");
			System.out.printf("%5s", pi.getGrade()+"\t");
			System.out.printf("%5s", pi.getCompany()+"\t");
			System.out.printf("%5s", pi.getDept()+"\t");
			System.out.printf("%5s", pi.getJob()+"\t");
			System.out.printf("%5s", pi.getCafename()+"\t");
			System.out.printf("%5s", pi.getNickname()+"\n");
		}

		System.out.println("=============================================================================================================================");
		System.out.println("★☆★☆검색이 완료되었습니다★☆★☆");
		System.out.println("★☆★☆메인메뉴로 돌아갑니다★☆★☆");
		
	}
	
	
	public void deleteInfor() {
		
		// 사용자 입력정보 변수

				System.out.print("삭제하고자 하는 이름 : ");
				PhoneMain.sc.nextLine();
				String searchName = PhoneMain.sc.nextLine();

				int resultCnt = dao.deleteInfor(searchName);

				if (resultCnt < 1) {
					System.out.println("["+searchName+"]"+"님의 정보가 없습니다.");
				} else {
					System.out.println("=============================================================================================================================");
					System.out.println("["+searchName+"]"+"님을 삭제합니다.");
					System.out.println("=============================================================================================================================");
					System.out.println("★☆★☆삭제가 완료되었습니다★☆★☆");
					System.out.println("★☆★☆메인메뉴로 돌아갑니다★☆★☆");
				
				}
	}
	
	
	public void editInfor() {
		// 1. 수정하고자 하는 데이터 유무 확인 
		// 2. 사용자로부터 데이터 받아서 전달
		

		// 사용자 입력정보 변수

		System.out.println("수정하고자 하는 이름 : ");
		PhoneMain.sc.nextLine();
		String searchName = PhoneMain.sc.nextLine();
		
		// 1. 수정하고자 하는 데이터 유무 확인 
		int rowCnt = dao.phoneSeachCount(searchName);
//		System.out.println(rowCnt);
		
		if(rowCnt>0) {
			
			PhoneInfor pi = dao.phoneSearchName(searchName);
			
			if(pi == null) {
				System.out.println("찾으시는 이름의 정보가 존재하지않습니다");
				return;
			}
		
			
			System.out.println("분류 : 1.대학 || 2.회사 || 3. 동호회");
			int select = PhoneMain.sc.nextInt();
			
			
			System.out.println("이름을 입력하세요");
			PhoneMain.sc.nextLine();
			String name = PhoneMain.sc.nextLine();
			
			System.out.println("번호를 입력하세요");
			String phonenumber = PhoneMain.sc.nextLine();
			
			System.out.println("이메일을 입력하세요");
			String email = PhoneMain.sc.nextLine();
			
			System.out.println("주소를 입력하세요");
			String address = PhoneMain.sc.nextLine();
			
			
			switch(select) {
			case 1:
				
				System.out.println("전공을 입력하세요");
				String major = PhoneMain.sc.nextLine();

				System.out.println("학년을 입력하세요");
				String grade = PhoneMain.sc.nextLine();
				
				String category = "UNIV";
				String company = null;
				String dept = null;
				String job = null;
				String cafename = null;
				String nickname = null;
				
				PhoneInfor newPi = new PhoneInfor(name, phonenumber, address, email, category, major, grade, company, dept, job, cafename, nickname);
				
				
				
				int resultUnivCnt = dao.editInfor(newPi);
				
				if (resultUnivCnt > 0) {
					System.out.println("정상적으로 수정되었습니다.");
					System.out.println(resultUnivCnt + "행이 수정되었습니다.");
				} else {
					System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
				}
				
				return;
				
			case 2:
				
				category= "COM";
				major = null;
				grade = null;
				cafename = null;
				nickname = null;
				
				System.out.println("회사명을 입력하세요");
				company = PhoneMain.sc.nextLine();
				
				System.out.println("부서명을 입력하세요");
				dept = PhoneMain.sc.nextLine();
				
				System.out.println("직업을 입력하세요");
				job = PhoneMain.sc.nextLine();
				
				
				newPi = new PhoneInfor(name, phonenumber, address, email, category, major, grade, company, dept, job, cafename, nickname);
				
				int resultComCnt = dao.editInfor(newPi);
				
				if (resultComCnt > 0) {
					System.out.println("정상적으로 수정었습니다.");
					System.out.println(resultComCnt + "행이 수정되었습니다.");
				} else {
					System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
				}
				
				return;
				
			case 3:
				
				System.out.println("동호회명을 입력하세요");
				cafename = PhoneMain.sc.nextLine();
				
				System.out.println("닉네임명을 입력하세요");
				nickname = PhoneMain.sc.nextLine();
				
				category = "CAFE";
				major = null;
				grade = null;
				company = null;
				dept = null;
				job = null;
				
				newPi = new PhoneInfor(name, phonenumber, address, email, category, major, grade, company, dept, job, cafename, nickname);
				
				int resultCafeCnt = dao.editInfor(newPi);
				
				if (resultCafeCnt > 0) {
					System.out.println("정상적으로 수정되었습니다.");
					System.out.println(resultCafeCnt + "행이 수정되었습니다.");
				} else {
					System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
				}
				
				return;
			}

			}

		}

	
	public void listInfor() {

		List<PhoneInfor> listInfor = dao.listInfor();

		if (listInfor != null && !listInfor.isEmpty()) {

			System.out.println("=============================================================================================================================");
			System.out.println("인덱스\t카테고리\t이름\t전화번호\t\t주소\t이메일\t\t전공\t학번\t회사\t부서\t직급\t동호회\t닉네임");
			System.out.println("=============================================================================================================================");
			for (int i = 0; i < listInfor.size(); i++) {
				System.out.printf("%3s", listInfor.get(i).getPidx()+"\t");
				System.out.printf("%5s", listInfor.get(i).getCategory()+"\t");
				System.out.printf("%5s", listInfor.get(i).getName()+"\t");
				System.out.printf("%12s", listInfor.get(i).getPhonenumber()+"\t");
				System.out.printf("%5s", listInfor.get(i).getAddress()+"\t");
				System.out.printf("%5s", listInfor.get(i).getEmail()+"\t");
				System.out.printf("%5s", listInfor.get(i).getMajor()+"\t");
				System.out.printf("%5s", listInfor.get(i).getGrade()+"\t");
				System.out.printf("%5s", listInfor.get(i).getCompany()+"\t");
				System.out.printf("%5s", listInfor.get(i).getDept()+"\t");
				System.out.printf("%5s", listInfor.get(i).getJob()+"\t");
				System.out.printf("%5s", listInfor.get(i).getCafename()+"\t");
				System.out.printf("%5s", listInfor.get(i).getNickname()+"\n");
				
			}
			System.out.println("=========================================================================================================================");
			System.out.println("★☆★☆출력이 완료되었습니다★☆★☆");
			System.out.println("★☆★☆메인메뉴로 돌아갑니다★☆★☆");
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}

		
		
	}
	
	
	
}
