
public class OperatorEx13 {

	public static void main(String[] args) {
		char c1 = 'a';
		
		// char c2 = c1+1; // 컴파일 에러 발생
		char c2 = (char)(c1+1);
		char c3 = 'a' + 1;
		// 컴파일러가 미리 덧셈연산을 수행하기 때문에 실행 시에는 덧셈 연산이 수행되지 않는다.
		// 그러나 수식에 변수가 들어가 있는 경우에는 컴파일러가 미리 계산을 할 수 없기 때문에 형변환을 해주어야 한다.
		// 그렇지 않으면 컴파일 에러가 발생한다. 
		
		System.out.println(c2);
		System.out.println(c3);
	}

}
