import java.util.Scanner; // Scanner클래스를 사용하기 위해 추가

class ScannerEx{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	// Scanner클래스의 객체를 생성
		// 입출력 관련 객체들은 사용한 다음에 반드시 닫아줘야 한다.
		// 그러나 화면입력 같은 경우에는 jvm에 의해 자동적으로 관리되기 때문에 닫을 필요가 없다.
		// eclipse가 볼 때는 사용한 다음에 닫아주지 않아서 경고메시지가 뜨지만 무시해도 좋다. 
		
		System.out.print("두 자리 정수를 하나 입력해주세요.>");
		String input = scanner.nextLine();	// 입력받은 내용을 input에 저장
		int num = Integer.parseInt(input);	// 입력받은 문자열을 int타입의 값으로 변환
		
		System.out.println("입력내용 :"+input);
		System.out.printf("num=%d%n", num);
	}
}