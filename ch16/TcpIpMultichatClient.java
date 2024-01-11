import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpIpMultichatClient {

	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("USAGE: java TcpIpMutichatClient 대화명");
			System.exit(0);
		}
		
		try {
			String serverIp = "127.0.0.1";
			// 소겟을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp, 9999);
			System.out.println("서버에 연결되었습니다.");
			Thread sender = new Thread(new ClientSender(socket, args[0]));
			Thread receiver = new Thread(new ClientReceiver(socket));
			
			sender.start();
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {}
	} // end of main
	
	static class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;
		String name;
		
		ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				this.name = name;
				out = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {}
		}
		
		public void run() {
			Scanner scanner = new Scanner(System.in);
			
			try {
				if(out!=null) {
					out.writeUTF(name);
				}
				while(out!=null) 
					out.writeUTF("[" + name + "]" + scanner.nextLine());
			} catch (IOException e) {}
		} // end of run
	} // end of class ClientSender
	
	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		
		ClientReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {}
		}
		
		public void run() {
			while(in!=null) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {}
			}
		}// end of run
	} // class ClientReceiver

}
