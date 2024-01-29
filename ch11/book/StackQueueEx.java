package book;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * stack타입의 참조변수 st를 선언하고 stack타입의 새로운 객체 생성
 * queue타입의 참조변수 q를 선언하고 구현체로 LinkedList를 사용하시오.
 *
 * st에 "0", "1", "2"를 저장하시오.
 * q에 "0", "1", "2"를 저장
 *
 * st와 q가 비어있지 않을 때까지 하나씩 출력하시오.
 */
public class StackQueueEx {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();	// Queue인터페이스의 구현체인 LinkedList를 사용
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("= Stack =");
		while(!st.empty()) {
			System.out.println(st.pop());
		}
		
		System.out.println("= Queue =");
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
