import java.io.*;

public class StandardIOEx3 {

	public static void main(String[] args) {
		PrintStream  ps = null;
		FileOutputStream fos = null;
		
		try {
			String filePath = "/Users/ikjuncho/eclipse-workspace/ch15/예제/test.txt";
			fos = new FileOutputStream(filePath);
			ps = new PrintStream(fos);
			System.setOut(ps);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		System.out.println("Hello by System.out");
		System.err.println("Hello by System.err");
	}

}
