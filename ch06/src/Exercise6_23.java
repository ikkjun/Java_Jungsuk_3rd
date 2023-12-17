
public class Exercise6_23 {
	// max메서드를 작성하시오.
	static int max(int[] array) {
		if(array==null||array.length==0) {
			return -999999;
		}
		int max = array[0];
		
		for(int i=1;i<array.length;i++) {	// 배열의 두 번째 값부터 비교
			if (array[i]>max) {
				max = array[i];
			}
		}
		return max;
		
	}
	
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:"+max(data));
		System.out.println("최대값:"+max(null));
		System.out.println("최대값:"+max(new int[]{}));	// 크기가 0인 배열
	}

}
