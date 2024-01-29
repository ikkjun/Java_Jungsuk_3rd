import java.util.*; // Scanner 클래스를 사용하기 위해 추가

public class FlowEx5 {

	public static void main(String[] args) {		
		int score = 0;	// 점수를 저장하기 위한 변수
		char grade = ' '; // 학점을 저장하기 위한 변수. 공백으로 초기화한다. 
//		char grade = 'D';	// 리펙토링에 따르면 else 구문을 사용하는 것보다 초기값을 설정하는 것이 더 낫다고 함.
		
		System.out.print("점수를 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt(); //	화면을 통해 입력받은 숫자를 score에 저장
		
		if (score>=90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else {
			grade = 'D';
		}
		System.out.println("당신의 학점은 "+grade+"입니다.");
	}

}