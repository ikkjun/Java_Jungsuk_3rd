
public class Star0102 {

	public static void main(String[] args) {
		for (int i=1;i<=5;i++) {
			for (int j=1;j<=5;j++) {
				if(i==j)
					System.out.printf("*");
				else
					System.out.printf("     ");
			}
			System.out.println();
		}
	}

}
