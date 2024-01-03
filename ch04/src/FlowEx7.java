import java.util.*; // Scanner 클래스를 사용하기 위해 추가

public class FlowEx7 {

	public static void main(String[] args) {
		int usergame = 0;
		String comgame = ""; 
		
		System.out.print("가위, 바위, 보 중 하나를 입력하세요.>");
		
		Scanner scanner = new Scanner(System.in);
		String user = scanner.nextLine();	// 화면을 통해 입력받은 숫자를 user에 저장
		
		switch (user) {
		case "가위":
			usergame = 1;
			break;
		case "바위":
			usergame = 2;
			break;
		case "보":
			usergame = 3;
			break;
		default:
			System.out.println("다시 입력하세요."+usergame);
			break;
		}
		// 어떻게 하면 다시 입력하세요 뜨고 break할지 질문 
//		if (user == "가위") {
//			game = 1;
//		} else if (user == "바위") {
//			game = 2;
//		} else if (user == "보") {
//			game = 3;
//		} else {
//			System.out.println("다시 입력하세요.");
//		}
		int com = (int) (Math.random() * 3) + 1;	// 1, 2, 3 중 하나가 com에 저장됨
		
		if (com == 1) {
			comgame = "가위";
		} else if (com == 2) {
			comgame = "바위";
		} else if (com == 3) {
			comgame = "보";
		} 
		
		System.out.println("당신은 " + user + "를 냈습니다.");
		System.out.println("컴퓨터는 " + comgame + "를 냈습니다.");
		
		switch(usergame-com) {
		case 2: case -1:
			System.out.println("당신이 졌습니다.");
			break;
		case 0:
			System.out.println("비겼습니다.");
			break;
		case -2: case 1:
			System.out.println("당신이 이겼습니다.");
			break;
		}		
	}

}