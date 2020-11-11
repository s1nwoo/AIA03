package polyymorphism;

public class TvMain {

	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		
		CaptionTv cTv1 = new CaptionTv();
		
		Tv tv2 = new CaptionTv();
		
		// 참조변수의 형변환
		CaptionTv ctv2 = (CaptionTv)tv2;
//		((CaptionTv)tv2).caption();
		ctv2.caption();
		
//		자손타입의 참조변수로 조상타입의 인스턴스를 참조할 수 없다.
//		CaptionTv cTv2 = new Tv();

//		System.out.println(tv2.power);
		tv2.power();
//		System.out.println(tv2.power);
//		tv2.display();

		Tv tv3 = new IpTv();
		Tv tv4 = new SmartTv();
		
//		tv3.display();
//		tv4.display();

		Tv[] tvs = new Tv[4];
		
		tvs[0] = new Tv();
		tvs[1] = new CaptionTv();
		tvs[2] = new IpTv();
		tvs[3] = new SmartTv();
		
		for(int i=0;i<tvs.length;i++) {
			tvs[i].display();
		}
		
		
	}
	
}
