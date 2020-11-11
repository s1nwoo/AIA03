package lms.model;

import java.util.List;

//자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
public class TeacherListView {

	// 교수 목록DTO
	private List<Teacher> teacherList;

	public TeacherListView(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	@Override
	public String toString() {
		return "TeacherListView [teacherList=" + teacherList + "]";
	}

	
}
