
public class Exercise14_6 {

	public static void main(String[] args) {
		int max = 0;
		String[] strArr = {"aaaa","bb","c","ddddd"};
		for(int i=0;i<strArr.length;i++) {
			int len = strArr[i].length();
			if(len > max) {
				max = len;
			}
		}
		System.out.println(max);
	}

}
