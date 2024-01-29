public class Exercise4_11 {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1+","+num2);
		
		for (int i = 0; i < 8; i++) {
			num3=num1+num2;	// 세번째 값은 첫번째와 두번째 값을 더해서 얻는다.
			System.out.print(","+num3);	// 세 번째 수열 출력
			
			num1=num2;		// 두 번째 수열을 첫 번째 값으로 한다.
			num2=num3;		// 세 번째 수열을 두 번째 값으로 한다.
		}
	}
}
