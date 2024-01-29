
public class Star0108 {

	public static void main(String[] args) {
		for (int i=1;i<=5;i++) {
			for (int j=1;j<=9;j++) {
				if(i+j>=6 && j<=i+4)
					System.out.printf("*");
				else
					System.out.printf(" ");
			}
			System.out.println();
		}
	}
}
