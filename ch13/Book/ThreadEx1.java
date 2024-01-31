package 예제;

public class ThreadEx1 {
	public static void main(String args[]) {
		// Thread 이용해서 쓰레드의 이름을 다섯 번 출력
		MyThread th1 = new MyThread();

		// Runnable 이용해서 쓰레드의 이름을 다섯 번 출력
		Runnable r = new MyRunnable();
		Thread th2 = new Thread(r);

		th1.start();
		th2.start();

	}
}
class MyThread extends Thread {
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(getName());
		}
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
