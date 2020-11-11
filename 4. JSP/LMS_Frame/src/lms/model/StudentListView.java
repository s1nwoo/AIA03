package lms.model;

import java.util.List;

//자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
public class StudentListView {

	// 학생 목록DTO
	private List<Student> studentList;

	public StudentListView(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "StudentListView [studentList=" + studentList + "]";
	}
	
	
	
}
