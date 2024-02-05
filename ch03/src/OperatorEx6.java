
public class OperatorEx6 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
//		byte c = a + b; // 컴파일 에러가 발생한다. 명시적으로 형변환이 필요하다.
		// 연산자 '+'는 두 개의 피연산자들의 자료형을 int형으로 변환한 다음 연산을 수행한다. 
		// 그래서 'a+b'의 연산결과는 byte형이 아닌 int형(4 byte)인 것이다. 4 byte의 값을 1byte의 변수에 형변환없이 저장하려고 했기 때문에 에러가 발생하는 것이다.
		
		byte c = (byte)(a + b);
		System.out.println(c);
	}

}
