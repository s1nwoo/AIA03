package ex;

import java.util.TreeSet;
import java.util.Iterator;

public class Person implements Comparable<Person>{

	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	void showData() {
		System.out.println("이름 "+this.name);
		System.out.println("나이 "+this.age);
	}
	
	
	@Override
	public int compareTo(Person o) {
	
		int result = 0;
		
		if(this.age > o.age) {
			result = 1; // 양수;
		} else if(this.age < o.age) {
			result = -1; // 음수
		} else {
			result = 0;
		}
		
		return result;

	}

	public static void main(String[] args) {
		
		TreeSet<Person> tree = new TreeSet<Person>();
		
		tree.add(new Person("Son", 27));
		tree.add(new Person("Park", 30));
		tree.add(new Person("Lee", 20));
		
		
		Iterator<Person> itr = tree.iterator();
		
		while(itr.hasNext()) {
			itr.next().showData();
		}
		
		
	}
}
	
	
	

