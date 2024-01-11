import java.util.*;

public class FlowEx24 {

	public static void main(String[] args) {
		int i = 11;
		
		System.out.println("카운트 다운을 시작합니다.");
		
		while(i-- != 0) {
			System.out.println(i);
			
			for(int j=0;j<2_000_000_000;j++) {
				// 아무런 내용도 없는 빈 문장
				// 조건식과 증감식을 2,000,000,000번 반복하면서 시간을 보냄
				// 블록 내에 문장이 하나뿐일 때 괄호{}를 생략할 수 있다.
			}
		}
		System.out.println("GAME OVER");
	}
}
