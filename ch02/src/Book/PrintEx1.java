
public class PrintEx1 {

	public static void main(String[] args) {
		// println()의 단점 - 출력 형식 지정 불가
		// 1. 실수의 자리 수 조절 불가 - 소수점 n자리만 출력하려면?
		// System.out.println(10.0 / 3); // 3.333...
		// 2. 10진수로만 출력된다. - 8진수, 16진수로 출력하려면?
		// System.out.println(0x1A); // 26 
		// printf()로 출력형식 지정가
		// printf()의 지시자: javaAPI -> formatter
		
		int age = 28;
		System.out.printf("age:%d", age); 	// 출력 후 줄바꿈을 하지 않는다.
		System.out.printf("age:%d\n", age);	// 출력 후 줄바꿈을 한다.
		System.out.printf("%d살\n", age);	// 출력 후 줄바꿈을 한다.
		
		float f = 123.456789f;
		System.out.printf("%f%n", f);
		double d = 123.456789;
		System.out.printf("%f%n", d);
		// %f: 지시자, %n(\n): 개행문자
		// float는 정밀도가 7자리이기 때문에 앞에서 7자리까지만 정확하다.
		// 7자리 이후부터는 의미 없는 숫자 
		// 그러므로 정밀도가 높은 double를 사용해야 한다.
		// double의 정밀도는 15이다. 
		
		byte b = 1;
		short s = 2;
		char c = 'A';
		
		int finger = 10;
		long big = 100_000_000_000L;
		long hex = 0xFFFF_FFFF_FFFF_FFFFL; // long hex = 0xFFFFFFFFFFFFFFFFL;
		
		int octNum = 010;	// 8진수 10, 10진수로는 8
		int hexNum = 0x10;	// 16진수 10, 10진수로는 16
		int binNum = 0b10; 	// 2진수 10, 10진수로는 2
		
		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);
		System.out.printf("c=%c, %d %n",c, (int)c); // 자바에서는 char타입의 값을 int타입으로 형변환해야만 '%d'로 출력할 수 있다.
		System.out.printf("finger=[%5d]%n", finger);
		System.out.printf("finger=[%-5d]%n", finger);
		System.out.printf("finger=[%05d]%n", finger);
		System.out.printf("big=%d%n", big);
		System.out.printf("hex=%#x%n", hex); // #은 접두사(16진수 0x, 8진수 0)
		System.out.printf("octNum=%o, %d%n", octNum, octNum); 
		System.out.printf("hexNum=%x, %d%n", hexNum, hexNum); 
		System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum); 
	}

}
