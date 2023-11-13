
public class CastingEx {

	public static void main(String[] args) {
		// 타입 간의 변환방법
		// 1. 문자와 숫자간의 변환
		String str = "3";
		
		System.out.println(str.charAt(0) - '0');	// 문자 3에서 문자 0을 빼면 숫자 3
		System.out.println('3' - '0' + 1);
		System.out.println(Integer.parseInt("3") + 1);
		System.out.println("3" + 1);
		System.out.println(3 + '0'); // '0'은 숫자로 48
		// 2. 문자열로의 변환
		// 3. 문자열을 숫자로 변환
	}

}
