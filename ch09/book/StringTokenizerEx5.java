package Examples;

import java.util.StringTokenizer;

public class StringTokenizerEx5 {

	public static void main(String[] args) {
		String data = "100,,,200,300";
		
		String[] result = data.split(",");
		StringTokenizer st = new StringTokenizer(data, ",");
		
		for(int i=0;i<result.length;i++) 
			System.out.println(result[i] + "|");
		
		System.out.println("개수:" +result.length);
		
		int i=0;
		for(;st.hasMoreTokens();i++) 
			System.out.println(st.nextToken() + "|");
		
		System.out.println("개수:" +i);
	}	// main의 끝
	
}
