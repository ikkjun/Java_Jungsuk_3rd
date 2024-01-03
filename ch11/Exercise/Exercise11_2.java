package Exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

/* 
 * 3,6,2,7
 * 2367
 * 7
 * 6
 * 3
 * 2
 */
public class Exercise11_2 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		
		HashSet set = new HashSet(list);
		TreeSet tset = new TreeSet(set);
		Stack stack = new Stack();
		stack.addAll(tset);
		
		while(!stack.empty())
			System.out.println(stack.pop());
	}

}


