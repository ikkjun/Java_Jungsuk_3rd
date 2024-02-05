class MyPoint {
	int x;
	int y;
	
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	// 인스턴스메서드 getDistance를 작성하시오.
	double getDistance(int a, int b) {
		double result = Math.sqrt((a - x)*(a - x)+(b - y)*(b - y));
		return result;
	}
}
public class Exercise6_7 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1,1);
		
		// p와 (2,2)의 거리를 구한다.
		System.out.println(p.getDistance(2,2));
	}

}