package 예제12_5;

// 열거형 Direction에 EAST, SOUTH, WEST, NORTH 추가
enum Direction {EAST, SOUTH, WEST, NORTH}

public class EnumEx1 {
	public static void main(String[] args) {
		// Direction 타입의 참조변수 d1에 Direction의 EAST값을 저장
		Direction d1 = Direction.EAST;
		// Direction 타입의 참조변수 d2에 Direction의 West값을 저장
		Direction d2 = Direction.WEST;
		// Direction 타입의 참조변수 d3에 Direction의 EAST값을 저장
		Direction d3 = Direction.valueOf("EAST");

		// d1의 값을 출력
		System.out.println("d1" + d1);

		// d2의 값을 출력
		System.out.println("d2" + d2);

		// d3의 값을 출력
		System.out.println("d3" + d3);

		// d1과 d2를 비교
		System.out.println(d1 == d2);
		// d1과 d3을 ==로 비교
		System.out.println(d1 == d3);

		// d1과 d3을 compareTo로 비교
		System.out.println(d1.compareTo(d3));
		// d1과 d2를 compareTo로 비교
		System.out.println(d1.compareTo(d2));

		// d1을 인자로 받는 switch 작성
		// ex. EAST인 경우 The direction is EAST로 출력
		switch (d1) {
			case EAST:
				System.out.println("The direction is EAST");    break;
			case SOUTH:
				System.out.println("The direction is SOUTH");   break;
			case WEST:
				System.out.println("The direction is WEST");    break;
			case NORTH:
				System.out.println("The direction is NORTH");   break;
		}

		// Direction의 모든 상수를 Direction 타입의 배열 dArr에 저장
		Direction[] dArr = Direction.values();
		// Direction의 모든 상수의 이름과 정의된 순서 반환
		for(Direction dir : dArr) {
			System.out.println(dir.name() + ":" + dir.ordinal());
		}
	}
}
