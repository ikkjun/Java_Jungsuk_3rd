package Examples;

final class CardClass{
	String kind;
	int num;
	
	CardClass() {
		this("SPADE", 1);
	}
	
	CardClass(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	
	public String toString() {
		return kind + ":" + num;
	}
}
public class ClassEx1 {

	public static void main(String[] args) throws Exception {
		CardClass c = new CardClass("HEART", 3);		// new 연산자로 객체 생성
		CardClass c2 = CardClass.class.newInstance();	// Class객체를 통해서 객체 생성
		
		Class cObj = c.getClass();
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(cObj.getName());
		System.out.println(cObj.toGenericString());
		System.out.println(cObj.toString());
		
	}

}
