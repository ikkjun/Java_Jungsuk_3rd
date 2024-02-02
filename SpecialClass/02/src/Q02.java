
public class Q02 {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int[] arr2 = {1,3,2};
		
		int s=0;
		int b=0;
		
		// 두 배열 arr, arr2를 비교해서
		// ① 값이 같으면 b의 값을 증가 
		// ② 값이 같고 위치도 같으면 s의 값을 증가 
		// ③ s와 b의 값을 출력
		
		for (int i=0;i<arr.length;i++) {
			if (arr[i]==arr2[i])
				s++;
			for (int j=0;j<arr2.length;j++) {
				if ((arr[i]!=arr2[i]) && (arr[i]==arr2[j]))
				b++;
			}
		}
		System.out.printf("S= %d%n",s);
		System.out.printf("B= %d",b);
	}
}
