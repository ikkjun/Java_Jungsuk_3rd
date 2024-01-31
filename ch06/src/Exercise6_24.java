
public class Exercise6_24 {
	// abs 메서드를 작성하시오.
	static int abs(int value) { // return value>=0?value:-value;
		int result = 0;
		if(value<0) {
			result = value * (-1);
		} else {
			result = value;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value+"의 절대값:"+abs(value));
		value = -10;
		System.out.println(value+"의 절대값:"+abs(value));
	}

}
