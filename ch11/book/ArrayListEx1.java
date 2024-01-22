package book;

/**
 * ArrayList 타입의 참조변수 list1를 선언하고 크기가 10인 ArrayList 객체에  저장하라.
 * list1에 정수 5,4,2,0,1,3을 오토박싱을 사용하지 않고 추가하라.
 * ArrayList 타입의 참조변수 list2를 선언하고 원소로 list1의 첫 번째 원소부터 세 번째 원소를 갖게 해라.
 * list1과 list2를 출력하라.
 *
 * list1과 list2를 정렬하고 출력하라.
 * list1이 list2의 모든 원소를 포함하고 있는지 확인하라.
 * list2에 문자 B와 문자C를 추가하시오.
 * list2의 세 번째 인덱스에 A를 추가하시오.
 * list1과 list2를 출력하시오.
 * list2의 세 번째 원소를 AA로 바꾸시오.
 * list1과 list2를 출력하시오.
 *
 * list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제하시오.
 * list1과 list2를 출력하시오.
 * list2에서 list1에 포함된 객체들을 삭제하시오.
 * list1과 list2를 출력하시오.
 *
 * 반환 타입이 없는 print 메서드를 정의해서 출력할 때 사용하시오.
 * 매개변수는 ArrayList list1, ArrayList list2를 받고
 * list1: list1, list2: list2와 같은 형식으로 출력이 되게 하시오.
 */

import java.util.*;

public class ArrayListEx1 {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));

		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);

		Collections.sort(list1);	// list1과 list2를 정렬한다.
		Collections.sort(list2);	// Collections.sort(List l)
		print(list1, list2);

		System.out.println("list1.conatinsAll(list2):" + list1.containsAll(list2));

		list2.add("B");
		list2.add("C");
		list2.add(3,"A");
		print(list1, list2);

		list2.set(3,"AA");
		print(list1, list2);

		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));

		print(list1, list2);

		// list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i=list2.size()-1;i>=0;i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1, list2);
	}	// main의 끝

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}

}
