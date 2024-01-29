public class FlowEx29 {

	public static void main(String[] args) {
		for(int i=1; i<=100; i++) {
			System.out.printf("i=%d ",i);
			
			int tmp = i; // 변수 i는 for문의 제어에 사용되는 변수이기 때문에 i의 값을 다른 변수에 저장한다.
			
			do {
				// tmp%10이 3의 배수인지 확인(0제외)
				if (tmp%10%3 == 0 && tmp%10!=0)
					System.out.print("짝");
			} while ((tmp/=10)!=0);
			System.out.println();
		}
	}
}
