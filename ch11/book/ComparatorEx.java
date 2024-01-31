package book;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ComparatorEx 클래스의 main 메서드에 String 배열 strArr을 선언해서
 * strArr에 {"cat", "Dog", "lion", "tiger"}를 저장.
 *
 * Arrays.sort를 이용해서 strArr을 정렬
 * Arrays.toString을 이용해서 strArr 출력
 *
 * Arrays.sort로 String.Case_insensitive_order를 이용해 정렬
 * 출력
 *
 * Arrays.sort로 Descending()으로 정렬
 * 출력
 *
 * Descending 클래스는 Comparator구현해서 내림차순 정렬
 */

public class ComparatorEx {

	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr);	// String의 Comparable구현에 의한 정렬
		System.out.println("strArr=" + Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);	// 대소문자 구분안함
		System.out.println("strArr=" + Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());	// 역순 정렬
		System.out.println("strArr=" + Arrays.toString(strArr));
	}

}

class Descending implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2)*-1;	// -1을 곱해서 기본 정렬방식의 역으로 변경한다.
			
		}
		return -1;
	}
}