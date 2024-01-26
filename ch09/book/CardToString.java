package Examples;

class Card{
	String kind;
	int number;
	
	Card() {
		this("SPADE",1);
	}
	
	// 카드의 종류와 숫자를 받는 Card 클래스의 생성자
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
}
public class CardToString {

	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}

}
