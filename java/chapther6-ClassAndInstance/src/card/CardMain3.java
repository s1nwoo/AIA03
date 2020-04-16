package card;

public class CardMain3 {

	public static void main(String[] args) {

		
		for(int i=0; i<4; i++) {
			for(int j=1; j<14; j++) {
				
				String kind = "";
				
				switch(i) {
				case 0:
					kind = "Spade";
					break;
				case 1:
					kind = "Clover";
					break;
				case 2:
					kind = "Heart";
					break;
				case 3:
					kind = "Diamond";
					break;	
				}
			}
		}
		
	}

}
