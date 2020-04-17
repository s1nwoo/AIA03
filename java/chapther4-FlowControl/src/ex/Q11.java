package ex;

public class Q11 {

	public static void main(String[] args) {

//Q11. while문을 for문으로 변경하여 작성

//int num=0;
//int count=0;
//while((num++)<100){
//if(num%5!=0 || num%7!=0)
//continue;
//count++;
//System.out.println(num);
//}
//System.out.println("count: " + count);		
		
		int num = 1, count = 0;
		for(num=1; num<100; num++) {
			if(num%5!=0 || num%7!=0)
				continue;
			count++;
			System.out.println(num);
		}
		System.out.println("count: " +count);
	
	}
}