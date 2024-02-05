package book;

import java.util.Stack;

/**
 * StackEx1클래스에 변수 public static Stack back과
 * public static Stack forward에 각각 새로운 stack 객체를 만들어라.
 *
 * public static void printStatus() 메서드는
 * back: back
 * forward: forward
 * 현재 화면은 ' ...(back의 제일 위에 있는 원소가 출력) ' 입니다
 * 가 출력되도록 작성
 *
 * public static void goURL은 String 타입의 url을 매개변수로 받는다.
 * back Stack에 url저장
 * 만약 forward 스택이 비어있지 않다면 forward를 초기화
 *
 * public static void goForward()메서드는
 * 만약 forward가 비어있지 않다면 forward에서 원소 하나를 꺼내 back에 저장
 *
 * public static void goBack()메서드는
 * 만약 back이 비어있지 않다면 back에서 원소 하나를 꺼내 forward에 저장
 *
 * main 메서드에 goURL 1. 네이트, 2. 야후, 3. 네이버, 4. 다음을 저장
 *
 * goBack 실행
 * = '뒤로' 버튼을 누른 후 = 출력
 * printStatus() 실행
 *
 * goBack 실행
 * = '뒤로' 버튼을 누른 후 = 출력
 * printStatus() 실행
 *
 * goForward() 실행
 * = '앞으로' 버튼을 누른 후 = 출력
 * printStatus() 실행
 *
 * goURL codechobo.com 실행
 * = 새로운 주소로 이동 후 =
 * printStatus() 실행
 */
public class StackEx1 {
	public static Stack back	= new Stack();
	public static Stack forward = new Stack();
	
	public static void main(String[] args) {
		goURL("1.네이트");
		goURL("2.야후");
		goURL("3.네이버");
		goURL("4.다음");
		
		printStatus();
		
		goBack();
		System.out.println("= '뒤로' 버튼을 누른 후 =");
		printStatus();
		
		goBack();
		System.out.println("= '뒤로' 버튼을 누른 후 =");
		printStatus();
		
		goForward();
		System.out.println("= '앞으로' 버튼을 누른 후 =");
		printStatus();
		
		goURL("codechobo.com");
		System.out.println("= 새로운 주소로 이동 후 =");
		printStatus();
	}
	
	public static void printStatus() {
		System.out.println("back:" + back);
		System.out.println("forward" + forward);
		System.out.println("현재 화면은 '" + back.peek() + "' 입니다.");
		System.out.println();
	}
	
	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty())
			forward.clear();
	}
	
	public static void goForward() {
		if(!forward.empty())
			back.push(forward.pop());
	}
	
	public static void goBack() {
		if(!back.empty())
			forward.push(back.pop());
	}

}
