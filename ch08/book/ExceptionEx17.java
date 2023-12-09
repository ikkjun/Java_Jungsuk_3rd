
public class ExceptionEx17 {

	public static void main(String[] args) throws Exception {
		try {
			method1();
		} catch (Exception e) {
		System.out.println("main메서드에서 예외가 처리되었습니다.");
		}
	}	// main 메서드의 끝
	
	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1메서드에서 예외가 처리되었습니다.");
			throw e;
		}
	} // method1메서드의 끝
}	// class의 끝
