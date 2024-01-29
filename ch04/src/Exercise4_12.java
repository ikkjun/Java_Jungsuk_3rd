public class Exercise4_12 {

	public static void main(String[] args) {
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=3;j++) {
				int x=(j+1)+(i-1)/3*3;	// x의 값은 j를 잘 이용하면 구할 수 있음. x는 반복되는 성격.
				int y=i%3==0?3:i%3;		// y의 값은 i의 값을 잘 이용하면 구할 수 있음. y는 증가하는 성격.
				
				if(x>9)					// 9단가지만 출력한다. 이 코드가 없으면 10단까지 출력된다.
					break;
				
				System.out.print(x+"*"+y+"="+x*y+"\t");
			}
			System.out.println();
			if(i%3==0)
				System.out.println();
		}
	}
}
