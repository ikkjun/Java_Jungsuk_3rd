package Exercise;

public class Exercise9_9 {
	
	// delCh에 있는 문자가 src에 있는지 확인
	// src안에서 삭제해야 할 index 알아내기.
	public static String delChar(String src, String delCh) {
		StringBuffer sb = new StringBuffer(src.length());
		
		for(int i=0;i<src.length();i++) {
			char ch = src.charAt(i);
			
			// ch가 delCh에 포함되어 있지 않으면 sb에 추가
			if(delCh.indexOf(ch)==-1) 
				sb.append(ch);
			
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2   3  4\t5)" + " -> " + delChar("(1 2   3  4\t5)"," \t"));
	}

}

