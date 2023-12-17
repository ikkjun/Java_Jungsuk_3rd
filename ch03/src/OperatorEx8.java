
public class OperatorEx8 {

	public static void main(String[] args) {
		int a = 1_000_000;	// 1,000,000 1백만
		int b = 2_000_000;	// 2,000,000 2백만
		
		long c = a*b;		// a*b = 2,000,000,000,000?
		System.out.println(c);
		// int타입과 int타입의 연산결과는 int타입이기 때문에 결과는 전혀 다른 값이 출련된다.
		// 'a*b'의 결과가 이미 int타입의 값이므로 long형으로 자동 형변환되어도 값은 변하지 않는다.
		
		// 올바른 결과 
		long d = (long)a * b; // 1000000L * 2000000
		System.out.println(d);
	}

}
