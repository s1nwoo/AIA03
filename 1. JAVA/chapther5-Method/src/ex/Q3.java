package ex;

public class Q3 {

// Q3. 원의 반지름 정보를 전달하면, 원의 넓이를 계산해서 반환하는 메서드와 원의 둘레를 계산해서 반환하는 메서드를 각각 정의하고, 
//     이를 호출하는 main메서드를 정의하자. (2*π*r), (π*r∧2)	

	public static void main(String[] args) {

		System.out.println(area(5));
		System.out.println(round(5));

	}

	static float area(float a) {

		float PI = 3.14f;

		float area = PI * (a * 2);

		return area;

	}

	static float round(float a) {

		float PI = 3.14f;

		float round = PI * (float) Math.pow(a, 2);

		return round;

	}

}