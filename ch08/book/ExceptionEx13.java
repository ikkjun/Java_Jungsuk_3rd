
public class ExceptionEx13 {

	public static void main(String[] args) throws Exception {
		method1();	// 같은 클래스 내의 static 멤버이므로 객체생성 없이 직접 호출 가능
	}	// main메서드의 끝
	
	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1메서드에서 예외가 처리되었습니다.");
			e.printStackTrace();
		}
	}	// method2의 끝
}
