
public class OperatorEx9 {

	public static void main(String[] args) {
		long a = 1_000_000 * 1_000_000;
		long b = 1_000_000 * 1_000_000L;
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		// 연산 결과가 int타입의 최대값인 약 2*10^9을 넘으므로 오버플로우가 발생했다.
		// 이미 오버플로우가 발생한 겂을 아무리 long타입의 변수에 저장을 해도 소용이 없다.
		// 그러나 '1000000 * 1000000L'은 결과가 long타입이기 때문에 10^12를 저장할 수 있는 타입이므로 올바른 결과를 얻을 수 있다.
	}

}
