package ex;

public class Q2 {

//Q2	다음 메서드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달될 값의 크기만큼 전부 증가시킨다.
//		public static void addOneDArr(int[] arr, int add){
//		for (int i=0; i<arr.length; i++)
//		arr[i] +=add;
//		}
//		
//		이 메서드를 기반으로(이 메서들르 호출하는 형태로)int형 2차원 배열에 저장된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.
//		public static void addOneDArr(int[][] arr, int add) { . . . . . }
//		단, 위 메서드는 2차원 배열의 가로, 세로 길이에 상관없이 동작해야 하며, 위의 메서드가 제대로 동작하는지 확인하기 위한 main 메서드도 함께 정의해야 한다.

	void addOneArr(int[][] arr, int add) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] += add;
			}
		}

		for (int[] e : arr) {
			for (int f : e) {
				System.out.println(f);
			}
		}
	}

	public static void main(String[] args) {

		int[][] arr = {{50,50},{40,40}};

		Q2 add = new Q2();

		add.addOneArr(arr, 10);

	}

}
