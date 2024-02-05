package Examples;

import java.util.StringTokenizer;

public class StringTokenizerEx3 {

	public static void main(String[] args) {
		String source = "1,김천재,1000,1000|2,박수재,95,80,90|3,이자바,80,90,90";
		StringTokenizer st = new StringTokenizer(source, "|");
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			
			StringTokenizer st2 = new StringTokenizer(token, ",");
			while(st2.hasMoreTokens())
				System.out.println(st2.nextToken());
			System.out.println("------");
		}
		
		// String의 split(String regx) 사용
		String input = "삼십만삼천백십오";
		final String UNIT = "십백천만억조";
		StringTokenizer moneyst = new StringTokenizer(input, UNIT, true);
		
		while(moneyst.hasMoreTokens())
			System.out.println(moneyst.nextToken());
		
	}	// main의 끝

}
