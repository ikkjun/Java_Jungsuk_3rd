package Examples;

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
