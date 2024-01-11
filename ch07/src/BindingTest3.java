
public class BindingTest3 {

	public static void main(String[] args) {
		BParent3 p = new BChild3();
		BChild3 c = new BChild3();
		
		System.out.println("p.x = "+p.x);
		p.method();
		System.out.println();
		System.out.println("c.x = "+c.x);
		c.method();
	}

}

class BParent3 {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}

class BChild3 extends BParent3 {
	int x = 200;
	
	void method() {
		System.out.println("x="+x);	// 	this.x와 같다.
		System.out.println("super.x="+super.x);
		System.out.println("this.x="+this.x);
	}
}