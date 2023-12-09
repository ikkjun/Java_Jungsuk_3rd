public class Exercise4_10 {

	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while(num>0) { // 왜 num>=0이면 무한 루프에 빠질까요??
			int tmp=num%10;
			sum+=tmp;
			num/=10;
		}
		System.out.println("sum="+sum);
	}
}
