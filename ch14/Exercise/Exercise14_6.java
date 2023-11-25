import java.util.Random;

public class Exercise14_6 {

	public static void main(String[] args) {
		new Random().ints(1, 46)	// 1~45 사이의 정수(46은 포함 안 됨)
					.distinct()		// 중복 제거
					.limit(6)		// 6개만
					.sorted()		// 정렬
					.forEach(System.out::println);	// 화면에 출력
	}

}
