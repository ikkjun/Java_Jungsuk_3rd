package book;

/**
 * 상수 LIMIT을 10으로 저장
 * 문자열 타입의 source에 "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ" 저장
 * 정수 타입의 변수 length에 source의 길이를 저장하시오.
 *
 * List타입의 list에 length에서 LIMIT을 나누고 10을 더한 크기의 새로운 ArrayList를 저장하라.
 *
 * i는 0부터 시작하고 i가 length보다 작을 때까지 i에 LIMIT을 더하는 반복문을 작성하시오.
 * 만약 i에 LIMIT을 더한 것이 length보다 작다면 list에 source에 i부터 i+LIMIT까지의 원소를 저장하시오.
 * 그 이외에는 list에 source의 i만큼 저장하시오.
 *
 * list에 저장된 원소를 모두 출력하시오.
 */

import java.util.*;

public class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10;	// 자르고자 하는 글자의 개수를 지정한다.
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();

		List list = new ArrayList(length/LIMIT * 10);	// 크기를 약간 여유있게 잡는다.

		for(int i=0;i<length;i+=LIMIT) {
			if(i+LIMIT<length)
				list.add(source.substring(i, i+LIMIT));
			else
				list.add(source.substring(i));
		}

		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
