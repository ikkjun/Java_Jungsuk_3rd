package Exercise;

public class Exercise9_10 {
	
	public static String format(String str, int length, int alignment) {
		int diff = length - str.length();
		if(diff<0) {
			return str.substring(0, length);
		} else {
			char[] newChar = new char[length];
			char[] strArr = str.toCharArray();
			
			for(int i=0;i<newChar.length;i++) {
				newChar[i]=' ';
			}
			
			switch(alignment) {
			case 0:
			default:
				System.arraycopy(strArr, 0, newChar, 0, strArr.length);
				break;
			case 1:
				System.arraycopy(strArr, 0, newChar, diff/2, strArr.length);
				break;
			case 2:
				System.arraycopy(strArr, 0, newChar, diff, strArr.length);
				break;
			}
			
			// System.arraycopy(strArr, 0, newChar, alignment, strArr.length);
			return new String(newChar);
		}
	}

	public static void main(String[] args) {
		String str = "가나다";
		
		System.out.println(format(str,7,0));	// 왼쪽 정렬
		System.out.println(format(str,7,1));	// 가운데 정렬
		System.out.println(format(str,7,2));	// 오른족 정렬
	}

}

