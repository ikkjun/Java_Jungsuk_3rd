
public class BindingTest {

	public static void main(String[] args) {
		BParent p = new BChild();
		BChild c = new BChild();
		
		System.out.println("p.x = "+p.x);
		p.method();
		
		System.out.println("c.x = "+c.x);
		c.method();
	}

}

class BParent {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class BChild extends BParent {
	int x = 200;
	void method() {
		System.out.println("Child Method");
	}
}