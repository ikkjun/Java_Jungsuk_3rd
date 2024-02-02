
public class OperatorEx17 {

	public static void main(String[] args) {
		double pi = 3.141592;
		double shortPi = (int)(pi * 1000 + 0.5) / 1000.0;
		
		System.out.println(shortPi);
		// double과 double의 나눗셈이므로 결과는 double인 3.142가 된다.
	}

}
