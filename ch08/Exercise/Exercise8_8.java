import java.util.*;

public class Exercise8_8 {
	public static void main (String[] args) {
		// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int)(Math.random() * 100) + 1;
		int input = 0;	// 사용자 입력을 저장할 공간
		int count = 0;	// 시도 횟수를 세기 위한 변수
		
			do {
				count++;
				System.out.print("1과 100사이의 값을 입력하세요 :");

				
				try {	// InputMismatchException 예외를 처리하기 위한 예외선언
					input = new Scanner(System.in).nextInt();
				} catch (InputMismatchException ime) {
					System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
					continue;
				}	// try-catch문 종료
				
					if(answer > input) {
						System.out.println("더 큰 수를 입력하세요.");
					} else if(answer < input) {
						System.out.println("더 작은 수를 입력하세요.");
					} else {
						System.out.println("맞췄습니다.");
						System.out.println("시도횟수는 " + count + "번입니다.");
						break;	// do-while문을 벗어난다.
					}
				
			} while(true); 	// 무한 반복문
		
	}	// end of main
}	// end of class HighLow
