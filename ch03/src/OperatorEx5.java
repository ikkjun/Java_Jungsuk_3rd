
public class OperatorEx5 {

	public static void main(String[] args) {
		int a = 10;
		int b = 4;
		
		System.out.printf("%d + %d = %d%n", a, b, a+b);
		System.out.printf("%d - %d = %d%n", a, b, a-b);
		System.out.printf("%d * %d = %d%n", a, b, a*b);
		System.out.printf("%d / %d = %d%n", a, b, a/b); // 소수점 이하는 버려진다.
		System.out.printf("%d / %f = %f%n", a, (float)b, a / (float)b);	// 실수형으로 자동 형변환 -> 실수형의 값을 결과로 얻는다.
	}

}
