package Exercise;

public class Exercise9_5 {

	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345ABA", "AB"));
		System.out.println(count("12345", "AB"));
		
		String src = "12345AB12AB345AB";
		String target = "AB";
	}
	
	public static int count(String src, String target) {
		int count = 0;	// 찾은 횟수
		int pos = 0;	// 찾기 시작할 위치
		
		//for(int i=0;i<src.length();i++) 
		while(true){
			if(src.indexOf(target, pos)!=-1) {
				count++;	
				pos += src.indexOf(target, pos); // target.length();
			} else
				break;
			
		}
		return count;
	}

}

