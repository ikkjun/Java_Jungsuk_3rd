
public class Exercise14_1 {

	public static void main(String[] args) {
		System.out.print("(a)");
		System.out.println("(name, i) -> System.out.println(name+'='+i)");
		
		System.out.print("(b)");
		System.out.println("x ->  x * x");
		
		System.out.print("(c)");
		System.out.println("() -> (int)(Math.random()*6)");
		
		System.out.print("(d)");
		System.out.println("(int[] arr) -> {");
		System.out.println("        int sum = 0;");
		System.out.println("        for(int i:arr)");
		System.out.println("        sum += i;");
		System.out.println("        return sum;");
		System.out.println("    }");
		
		System.out.println("(e)");
		System.out.println("() -> new int[]{}");
	}

}
