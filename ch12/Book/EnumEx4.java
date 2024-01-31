package 예제12_8;

package Book;

// MyEnum을 조상으로 하고 Comparable을 구현하는 추상 클래스 MyEnum 선언
abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
	// MyEnum 클래스는 static int id, int oridinal, String name을 변수로 갖는다.
	static int id = 0;
	int ordinal = 0;
	String name = "";

	// public int ordinal() 메서드는 ordinal 반환
	public int ordinal() { return ordinal; }

	// MyEnum 생성자는 String name을 매개변수로 받고 ordinal에는 id의 값이 하나씩 증가하도록 선언
	MyEnum(String name) {
		this.name = name;
		ordinal = id++;
	}

	// public int compareTo메서드는 ordinal값의 차이를 반환
	public int compareTo(T t) {
		return ordinal - t.ordinal();
	}
}

// 추상클래스 MyTransportation은 MyEnum을 상속받는다.
abstract class MyTransportation extends MyEnum {
	// MyTransportation은 BUS, TRAIN, SHIP, AIRPLANE을 열거형 원소로 갖는다.
	// BUS의 요금은 100, TRAIN의 요금은 150, SHIP의 요금은 100, AIRPLANE의 요금은 300이다.
	// 각각의 원소로 MyTransportation 생성자를 이용해 Transportation과 그 요금이 곱한 값을 반환하도록 작성
	static final MyTransportation BUS = new MyTransportation("BUS", 100){
		int fare(int distance) {return BASIC_FARE * distance;}
	};


	static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150){
		int fare(int distance) {return BASIC_FARE * distance;}
	};

	static final MyTransportation SHIP = new MyTransportation("SHIP", 100){
		int fare(int distance) {return BASIC_FARE * distance;}
	};

	static final MyTransportation AIRPLANE = new MyTransportation("AIRPLANE", 100){
		int fare(int distance) {return BASIC_FARE * distance;}
	};

	// 생성자는 private이며, String name과 int basicFare를 매개변수로 받는다.
	MyTransportation(String name, int basicFare) {
		super(name);
		BASIC_FARE = basicFare;
	}

	// protected final int BASIC_FARE선언
	protected final int BASIC_FARE;

	// 추상 메서드 int fare는 매개변수 int distance를 갖는다.
	abstract int fare(int distance);

	// public String name()은 name반환
	public String name() {return name;}

	// public String toString()은 name 반환
	public String toString() {return name;}
}

public class EnumEx4 {
	public static void main(String[] args) {
		// MyTransportation 타입의 참조변수 t1에 BUS 저장
		MyTransportation t1 = MyTransportation.BUS;

		// MyTransportation 타입의 참조변수 t2에 BUS 저장
		MyTransportation t2 = MyTransportation.BUS;

		// MyTransportation 타입의 참조변수 t3에 TRAIN 저장
		MyTransportation t3 = MyTransportation.TRAIN;

		// MyTransportation 타입의 참조변수 t4에 SHIP 저장
		MyTransportation t4 = MyTransportation.SHIP;

		// MyTransportation 타입의 참조변수 t5에 AIRPLANE 저장
		MyTransportation t5 = MyTransportation.AIRPLANE;

		// t1의 이름과 순서를 출력
		System.out.println(t1.name() + ":" + t1.ordinal());
		// t2의 이름과 순서를 출력
		System.out.println(t2.name() + ":" + t2.ordinal());

		// t3의 이름과 순서를 출력
		System.out.println(t3.name() + ":" + t3.ordinal());

		// t4의 이름과 순서를 출력
		System.out.println(t4.name() + ":" + t4.ordinal());

		// t5의 이름과 순서를 출력
		System.out.println(t5.name() + ":" + t5.ordinal());

		// t1과 t2를 비교
		System.out.println(t1.equals(t2));
	}
}
