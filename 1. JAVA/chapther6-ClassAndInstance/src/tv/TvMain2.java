package tv;

public class TvMain2 {

	public static void main(String[] args) {

		// 서로 다른 공간을 생성
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		
		System.out.println(tv1==tv2);
	
		System.out.println("------------------------");
		System.out.println("tv1 의 channel : " + tv1.channel);
		System.out.println("tv2 의 channel : " + tv2.channel);
		
		System.out.println("------------------------");
		
		tv1.channel = 10;
		System.out.println("tv1의 channl을 10으로 변경");
		
		System.out.println("tv1 의 channel : " + tv1.channel);
		System.out.println("tv2 의 channel : " + tv2.channel);
	}

}
