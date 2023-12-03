
public class OperatorEx22 {

	public static void main(String[] args) {
		float f = 0.1f;	// f에 0.10000000149011612로 저장된다.
		double d = 0.1;	// d에 0.10000000000000001로 저장된다.
		double d2 = (double)f;
		
		System.out.printf("10.0==10.f	%b%n", 10.0==10.0f);
		System.out.printf("0.1==0.1f	%b%n", 0.1==0.1f);
		// 정수형과 달리 실수형은 근사값으로 저장되므로 오차가 발생한다.
		// 10.0f는 오차없이 저장할 수 있는 값이라서 double로 형변환해도 그대로 10.0이 되지만,
		// 0.1f는 저장할 때 2진수로 변환하는 과정에서 오차가 발생한다. 
		// double타입의 상수인 0.1도 저장되는 과정에서 오차가 발생하지만, float타입의 리터럴인 0.1f보다 적은 오차로 저장된다. 
		System.out.printf("f=%19.17f%n", f);
		System.out.printf("f=%19.17f%n", d);
		System.out.printf("f=%19.17f%n", d2);
		System.out.printf("d==f	%b%n", d==f);
		System.out.printf("d==d2	%b%n", d==d2);
		System.out.printf("d==f	%b%n", d2==f);
		System.out.printf("(float)d==f	%b%n", (float)d==f);
		
	}

}
