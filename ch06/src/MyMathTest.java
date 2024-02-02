public class MyMathTest {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		long result1 = mm.add(5L, 3L);	// 자동 형변환 가능
		long result2 = mm.subtract(5L, 3L);	
		long result3 = mm.multiply(5L, 3L);	
		double result4 = mm.divide(5L, 3L);	
		long result5 = mm.max(5L, 3L);	
		
		System.out.println("add(5L, 3L) = " + result1);
		System.out.println("subtract(5L, 3L) = " + result2);
		System.out.println("multiply(5L, 3L) = " + result3);
		System.out.println("divide(5L, 3L) = " + result4);
		System.out.println("max(5L, 3L) = " + result5);
		
	}

}

class MyMath{
	long add(long a, long b) {
		long result = a+b;
		return result;
		// return a+b;	// 위의 두 줄을 이와 같이 한 줄로 간단히 할 수 있다.
	}
	long subtract(long a, long b) {return a - b;}
	long multiply(long a, long b) {return a*b;}
	double divide(double a, double b) {return a/b;}
	// 두 값을 받아서 둘 중에 큰 값을 반환하는 메서드를 작성하시오.
	long max(long a, long b) {	// return a>b?a:b;
		long result = 0;
		if(a>b) {
			result = a;
		} else{
			result = b;
		} 
		return result;
	}
}