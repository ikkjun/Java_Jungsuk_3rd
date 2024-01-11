
public class VarEx2 {

	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		int tmp = 0;
		
		System.out.println("x:" + x + " y:" + y);
		
		tmp = x;
		x = y;
		y = tmp; // x값을 임시로 저장할 변수를 선언
		
		System.out.println("x:" + x + " y:" + y);
	}

}
