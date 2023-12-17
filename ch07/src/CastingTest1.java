
public class CastingTest1 {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null; // 형변환 할 때 실제 인스턴스가 무엇인지 확인하고 그 갯수를 넘지 않도록 하는 것이 중요하다.
		
		fe.water();
		car = fe;	// car = (Car) fe;에서 형변환이 생략된 형태다.
		// car.water();	// 컴파일 에러! Car타입의 참조변수인 car로는 water()를 호출할 수 없다.
		fe2 = (FireEngine)car;	// 자손타입 <- 조상타입
		fe2.water();
	}
}

class Car {
	String color;
	int door;
	
	void drive() {
		System.out.println("drive, Brrr!");
	}
	
	void stop() {
		System.out.println("stop!!!");
	}
	
}

class FireEngine extends Car {
	void water() {
		System.out.println("water!!!");
	}
}
