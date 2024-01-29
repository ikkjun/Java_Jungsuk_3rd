/*
Person클래스의 멤버로는 long타입의 id와 오버라이딩한 equals메서드, long타입의 id를 매개변수로 받는 생성자가 있다.
매개변수 obj가 Person으로 형변환할 수 있다면 id와 obj의 id를 비교하여 옳으면 true, 다르면 false를 반환하라.

EqualsEx2 클래스의 메인메서드에서 8011081111222L를 매개변수로 하는 Person 타입 p1과 p2의 객체를 각각 생성한다.
1. 등호연산자를 이용해서 2. equals메서드를 사용해서 p1과 p2가 같다면 "같은 사람이다" 다르면 "다른 사람이다"출력
 */
public class ExceptionEx2 {

	public static void main(String[] args) {
		int number = 100;
		int result = 0;
		
		for(int i=0;i<10;i++) {
		try {	
			result = number / (int)(Math.random() * 10);
			System.out.println(result);
			} catch (ArithmeticException e) {
				System.out.println("0");
			}
		}
			
	}

}
