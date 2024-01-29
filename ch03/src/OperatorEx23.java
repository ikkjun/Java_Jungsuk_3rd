
public class OperatorEx23 {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.printf("\"abc\"==\"abc\" ? %b%n", "abc"=="abc");
		System.out.printf(" str1==\"abc\" ? %b%n", str1=="abc");
		System.out.printf(" str2==\"abc\" ? %b%n", str2=="abc");
		// 내용은 같지만 서로 다른 객체라서 false를 결과로 얻는다. 
		// 그러나 equals()는 객체가 달라도 내용이 같으면 true를 반환한다.
		// 그래서 문자열을 비교할 때는 항상 equals()를 사용해야 한다.
		// 만일 대소문자를 구별하지 않고 비교하고 싶으면, equals() 대신 equalsIgnoreCase()를 사용하면 된다.
		System.out.printf("str1.equals(\"abc\") ? %b%n", str1.contentEquals("abc"));
		System.out.printf("str2.equals(\"abc\") ? %b%n", str2.contentEquals("abc"));
		System.out.printf("str2.equals(\"ABC\") ? %b%n", str1.contentEquals("ABC"));
		System.out.printf("str1.equalsIgnoreCase(\"ABC\") ? %b%n", str2.equalsIgnoreCase("ABC"));
	}

}
