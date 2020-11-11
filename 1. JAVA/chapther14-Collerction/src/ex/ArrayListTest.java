package ex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {

		// List<E> → ArrayList<E>
		// List<E> : 저장 순서를 가진다. 데이터의 중복 저장이 가능하다.
		// 순서가 있다는 것은 일괄처리가 가능하다는 것이다.(반복적인 동일한 작업을 빠르게 처리)
		
		
		// ArrayList 인스턴스 생성 : Integer 타입의 객체만 저장
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		ArrayList<Integer> list = new ArrayList<>(); // 인스턴스 생성시 자료형만 생략 가능하다.
//		List<Integer> list = new ArrayList<>(); // 다형성
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		// List<E> 정의된 메서드 → 
		// add(E) : 인스턴스의 저장
		// remove(index) : 해당 index의 요소를 삭제
		// size() : List 요소의 개수를 반환
		// get(index) : 해당 index 위치의 요소를 반환 

		// 데이터의 저장 : 저장의 순서를 가지고 있다.
		list.add(40); // Auto Boxing
		list.add(new Integer(10));
		list.add(new Integer(20));
		list.add(new Integer(30));
		
		// 데이터의 참조
		System.out.println("저장된 데이터를 확인합니다.");
		// 반복문을 통해 일괄 참조 가능
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		// 데이터의 삭제
		list.remove(1);
		System.out.println("데이터 삭제 후 데이터를 확인합니다.");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
	
}
