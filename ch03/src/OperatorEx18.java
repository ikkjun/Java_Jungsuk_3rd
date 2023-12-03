
public class OperatorEx18 {

	public static void main(String[] args) {
		double pi = 3.141592;
		double shortPi1 = Math.round(pi * 1000) / 1000;
		double shortPi2 = Math.round(pi * 1000) / 1000.0;
		System.out.println(shortPi1);
		System.out.println(shortPi2);
	}

}
