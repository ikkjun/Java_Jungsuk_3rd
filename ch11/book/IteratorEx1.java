package book;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList 타입의 list에 새로운 객체룰 생성하고
 * "1", "2", "3", "4", "5"를 추가하라
 * iterator를 사용하여 list에 있는 모든 원소를 출력하라.
 */
public class IteratorEx1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("5");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("1");
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
	} // main

}
