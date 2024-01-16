package Examples;

/*
Point클래스는 Cloneable 인터페이스를 구현하며 멤버변수로 int타입의 x, y를 갖는다.
Point 클래스는 정수 타입의 x, y를 매개변수로 갖는 생성자를 가지고 있다.
toString을 오버라이딩하여 x와 y의 좌표를 출력하라
clone메서드를 구현하여 Objec 타입의 참조변수 obj는 null로 선언한다.
obj에 super.clone를 대입하고 예외처리를 하라.
마지막으로 obj를 리턴하라.

CloneEx1 클래스의 메인메서드에서 Point타입의 original 참조변수로 Point객체에 3, 5를 대입한 객체를 생성하시오.
Point 타입의 copy 참조변수에는 original을 복제해서 Point 타입의 새로운 객체를 생성하시오.
변수 original과 copy를 출력하시오.
 */
class Point implements Cloneable {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "x=" + x + ", y=" + y;
	}

	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();	// clone() 은 반드시 예외처리를 해주어야 한다.
		} catch(CloneNotSupportedException e) {}
		return obj;
	}
}

public class CloneEx2 {

	public static void main(String[] args) {
		PointCopy original = new PointCopy(3,5);
		PointCopy copy = (PointCopy)original.clone();	// 복제(clone)해서 새로운 객체 생성
		System.out.println(original);
		System.out.println(copy);
	}

}