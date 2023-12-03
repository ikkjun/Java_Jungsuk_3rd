public class FlowEx30 {

	public static void main(String[] args) {
		int i = 0;
		int sum = 0;
		
		while(true) {
			if(sum>100)
				break;
			++i;
			sum += i; // ++i와 sum+=i를 sum+=++i로 줄여 쓸 수 있다.
		}
		System.out.println("i="+i);
		System.out.println("sum="+sum);
	}
}
