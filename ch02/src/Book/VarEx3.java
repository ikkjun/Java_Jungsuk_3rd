
public class VarEx3 {

	public static void main(String[] args) {
		final int score = 100; // 변수의 타입 앞에 final을 붙이면 상수를 선언하게 된다.
//		score = 200; // 주석처리는 command + /
		
		System.out.println(score);
		
		boolean power = true;
		System.out.println(power);
		
		byte b = 127; // -128 ~ 127
		
		int oct = 010;	// 8진수, 10진수로 8
		int hex = 0x10;	// 16진수, 10진수로 16
		System.out.println(oct);
		System.out.println(hex);
		
		long l = 10_000_000_000L;
		
		float f = 3.14f;
		double d = 3.14f;
			
	}

}
