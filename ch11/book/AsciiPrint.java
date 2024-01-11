package book;

public class AsciiPrint {

	public static void main(String[] args) {
		char ch = ' ';
		// 공백 ' ' 이후의 문자을을 출력한다.
		for(int i=0;i<95;i++)
			System.out.print(ch++);
	}

}
