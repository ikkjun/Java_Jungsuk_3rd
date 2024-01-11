package Exercise;

import java.util.Scanner;

public class Exercise9_11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] guGuDan = new String[2];
		
		String input = scanner.nextLine();
		guGuDan = input.split(" ");
		
		int firstGuGuDan = 0;
		int secondGuGuDan = 0;
		
		
		try {
			if(guGuDan.length!=2)
				throw new Exception("시작 단과 끝 단, 두 개의 정수를 입력해주세요.");
			firstGuGuDan = Integer.parseInt(guGuDan[0]);
			secondGuGuDan = Integer.parseInt(guGuDan[1]);
			
			if(!(2<=firstGuGuDan && firstGuGuDan<=9 && 2<=secondGuGuDan && secondGuGuDan<=9))
				throw new Exception("단의 범위는 2와 9사이의 값이어야 합니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("USAGE : GugudanTest 3 5");
			System.exit(0);
		}
		
		if(firstGuGuDan > secondGuGuDan) {
			int tmp = firstGuGuDan;
			firstGuGuDan = secondGuGuDan;
			secondGuGuDan = tmp;
		}
		
		for(int i=firstGuGuDan;i<=secondGuGuDan;i++) {
				for(int j=1;j<=9;j++) {
					System.out.printf("%d*%d=%d%n",i,j,i*j);
				}
				System.out.println();
			}
		
	}

}

