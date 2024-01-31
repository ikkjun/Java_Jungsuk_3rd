
public class Star {

	public static void main(String[] args) {
		for(int i=1;i<10;i++) {
			System.out.printf("%d %d %d %d %d %d %d %d %n", i, (10-i), (i*2), (i+2), (i-1)*2, i*i, (i -1)%3+1, (i-1)/3);
			// 삼항 연산자 쓰지 말기
		}
	}
}
