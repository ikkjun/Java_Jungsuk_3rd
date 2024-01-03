package Exercise;

public class Exercise9_6 {
	
	public static String fillZero(String src, int length) {
		String result = "";
		
		if(src == null || src.length() == length) return src;
		if(src.length()<=0) return "";
		if(src.length()>length) {
			for(int i=0;i<length;i++) {
				result += src.charAt(i);
			}
		} else {
			char[] tempResult = new char[length];
			for(int i=0;i<tempResult.length;i++) {
				tempResult[i]='0';
			}
			int x = 0;
			for(int i=length-src.length();i<length;i++) {
				tempResult[i] = src.charAt(x++);
			}
			result = new String(tempResult);
		}
		
			
		return result;
	}

	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src,12));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,5));
	}

}

