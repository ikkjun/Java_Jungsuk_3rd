import Exercise13_2.Thread2;

public class Exercise13_1 {

	public static void main(String[] args) {		
		Runnable r = new Thread2();
		Thread th = new Thread(r);
		
		th.start();
	}

}

class Thread1 extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.println('-');
		}
	}
}

class Thread2 implements Runnable {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.println('-');
		}
	}
}