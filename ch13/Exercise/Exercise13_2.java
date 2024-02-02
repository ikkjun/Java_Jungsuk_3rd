package Exercise13_2;

public class Exercise13_2 {

	public static void main(String[] args) {
		Thread2 t1 = new Thread2();
		t1.run();
		
		for(int i=0;i<10;i++) 
			System.out.print(i);
		
		System.out.println();
		System.out.println("정답: b");
	}

}

class Thread2 extends Thread {
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.print(i);
		}
	}
}