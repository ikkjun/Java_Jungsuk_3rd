
public class BindingTest2 {

	public static void main(String[] args) {
		BParent2 p = new BChild2();
		BChild2 c = new BChild2();
		
		System.out.println("p.x = "+p.x);
		p.method();
		
		System.out.println("c.x = "+c.x);
		c.method();
	}

}

class BParent2 {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class BChild2 extends BParent2 {}