
public class Star0106 {

	public static void main(String[] args) {
		for (int i=1;i<=5;i++) {
			for (int j=1;j<=5;j++) {
				// System.out.printf("[%d, %d]",i,j);
				if(i+j<=6) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
