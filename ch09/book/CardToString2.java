package Examples;

// CardToString.java 파일에 있는 Card클래스를 상속받는다.
class Card2 extends Card{
	public String toString() {
		return "kind: " + kind + ", number : " + number;
	}
	 
}
public class CardToString2 {

	public static void main(String[] args) {
		Card2 c1 = new Card2();
		Card2 c2 = new Card2();
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}

}
