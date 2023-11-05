
public class Exercise14_5 {

	public static void main(String[] args) {
		int sum = 0;
		String[] strArr = {"aaa","bb","c","dddd"};
		for(int i=0;i<strArr.length;i++) {
			sum += strArr[i].length();
		}
		System.out.println("sum=" + sum);
	}

}
