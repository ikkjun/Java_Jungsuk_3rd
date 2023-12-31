package Exercise13_8;

import java.util.*;

public class Exercise13_8 {
	Vector words = new Vector();
	String[] data = {"태연", "유리", "윤아", "효연", "수영", "서현", "티파니", "써니", "제시카"};
	
	int interval = 2 * 1000;
	
	WordGenerator wg = new WordGenerator();

	public static void main(String[] args) {
		Exercise13_8 game = new Exercise13_8();
		
		game.wg.start();
		
		Vector words = game.words;
		
		while(true) {
			System.out.println(words);
			
			String prompt = ">>";
			System.out.print(prompt);
			
			// 화면으로부터 라인 단위로 입력받는다.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			
			int index = words.indexOf(input);
			
			if(index!=-1) {
				words.remove(index);
			}
		}
	}	// end of main
	class WordGenerator extends Thread {
		public void run() {
			/*
			 * 1. interval(2초)마다 배열 data의 값 중 하나를 임의로
			 * 선택해서 words에 저장한다.
			 */
			
			int rand = (int)(Math.random()*data.length);
			words.add(data[3]);
			try {
				Thread.sleep(2000);
			} catch (Exception e) {}
			
		}	// end of run
	}	// end of class
}
