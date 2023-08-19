
public class Star0109 {

	public static void main(String[] args) {
		for (int i=1;i<=5;i++) {
			for (int j=1;j<=5;j++) {
				if(i==j|| i+j==6 || j==1 || j==5 || i==3)
					System.out.printf("*");
				else
					System.out.printf(" ");
			}
			System.out.println();
		}
	}
}
