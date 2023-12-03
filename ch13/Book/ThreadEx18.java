package 예제;

public class ThreadEx18 {

	public static void main(String[] args) {
		ThreadEx17_1 th1 = new ThreadEx17_1("*");
		ThreadEx17_1 th2 = new ThreadEx17_1("**");
		ThreadEx17_1 th3 = new ThreadEx17_1("***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();	// 쓰레드 th1을 잠시 중단시킨다.
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();	// 쓰레드 th1이 다시 동작하도록 한다.
			Thread.sleep(3000);
			th1.stop();		// 쓰레드 th1을 강제 종료시킨다.
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {}
	}

}

class ThreadEx18_1 implements Runnable {
	boolean suspended = false;
	boolean stopped = false;
	
	Thread th;
	
	ThreadEx18_1(String name) {
		th = new Thread(this, name);
	}
	
	public void run() {
		String name = th.getName();
		
		while(!stopped) {
			if(!suspended) {
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				System.out.println(name + " - interrupted");
			} else {
				Thread.yield();
			}
		}
		System.out.println(name + " - stopped");
		
	}
	public void suspend() 	{
		suspended = true;
		th.interrupt();
		System.out.println(th.getName() + " - interrupted() by suspend()");
		}
	public void resume() 	{suspended = false;	}
	public void stop() 		{
		stopped = true;	
		th.interrupt();
		System.out.println(th.getName() + " - interrupt() by stop()");
		}
	public void start() 	{th.start(); 		}
}