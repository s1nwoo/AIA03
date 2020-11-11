package card;

public class CardMain2 {

	public static void main(String[] args) {

		Card c1 = new Card();
		c1.kind = "Heart";
		int number1 = 1;
		for(number1 = 1; number1 < 14; number1++) {
			System.out.println("Heart의 카드 " +number1 + " 생성하였습니다.");
		}
		System.out.println("--------------------");
		
		Card c2 = new Card();
		c2.kind = "Spade";
		int number2 = 1;
		for(number2 = 1; number2 < 14; number2++) {
			System.out.println("Spade의 카드 " +number2 + " 생성하였습니다.");
		}
		System.out.println("--------------------");
		
		Card c3 = new Card();
		c2.kind = "Diamond";
		int number3 = 1;
		for(number3 = 1; number3 < 14; number3++) {
			System.out.println("Diamond의 카드 " +number3 + " 생성하였습니다.");
		}
		System.out.println("--------------------");
		
		Card c4 = new Card();
		c2.kind = "Clover";
		int number4 = 1;
		for(number4 = 1; number4 < 14; number4++) {
			System.out.println("Clover의 카드 " +number4 + " 생성하였습니다.");
		}
	}
}