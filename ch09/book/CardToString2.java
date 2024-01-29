package Examples;

// CardToString.java 파일에 있는 Card클래스를 상속받는다.
/*
Card클래스의 멤버 변수로 String 타입의 kind와 int타입의 number가 있다.
기본 생성자는 kind는 "SPADE", number는 1을 갖도록 선언한다.
String 타입의 kind와 int타입의 number를 매개변수로 갖는 생성자를 만들어라. toString을 오버라이딩하여 kind와 number를 출력하시오.

CardToString2 클래스의 메인 메서드에서는 기본생성자를 객체로 하는 Card타입의 참조변수 c1과,
kind는 HEART, number는 10을 매개변수로 하는 객체는 참조변수 c2로 선언.
c1과 c2의 toString메서드를 출력
 */
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
